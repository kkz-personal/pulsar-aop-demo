package com.example.pulsaraopdemo.imp;

import com.example.pulsaraopdemo.common.enums.PushChannelEnum;
import com.example.pulsaraopdemo.service.PushService;
import lombok.AllArgsConstructor;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import java.util.*;


/**
 * @author kmz
 */
@Component
public class PushServiceImpl implements PushService {


    private Map<String, Producer<String>> topicProducerMap;

    /**
     * 推送消息队列
     */
    private ThreadLocal<List<PushMsg>> pipeline = ThreadLocal.withInitial(ArrayList::new);

    /**
     * 是否已经开始收集推送消息
     */
    private ThreadLocal<Boolean> proessing = ThreadLocal.withInitial(() -> false);


    /**
     * 推送
     *
     * @param channel 推送频道
     * @param value   推送的值
     * @param args    参数
     */
    @Override
    public void send(PushChannelEnum channel, Object value, Object... args) {

        String topic = channel.getTopic();
        String key = String.format(channel.getKey(), args);
        String valStr = JSON.toJSONString(value);

        this.pipeline.get().add(new PushMsg(key, valStr, topic));
    }

    @Override
    public void begin() {
        this.proessing.set(true);
        this.pipeline.remove();
    }

    @Override
    public void commit() {

    }

    /**
     * 回滚
     */
    @Override
    public void rollback() {
        this.pipeline.remove();
        this.proessing.set(false);
    }

    @Override
    public boolean processing() {
        return this.proessing.get();
    }

    @Autowired
    public void setPulsarClient(final PulsarClient pulsarClient) {

        this.topicProducerMap = new HashMap<>();

        // 实例化所有topic的Producer实例
        Arrays.stream(PushChannelEnum.values()).map(PushChannelEnum::getTopic).distinct().forEach(topic -> {
            try {
                Producer<String> producer = pulsarClient.newProducer(Schema.STRING).topic(topic).create();
                this.topicProducerMap.put(topic, producer);
            } catch (Exception e) {
                throw new RuntimeException("pulsar producer create error", e);
            }
        });
    }


    @AllArgsConstructor
    public class PushMsg {
        String key;
        String value;
        String topic;
    }


}
