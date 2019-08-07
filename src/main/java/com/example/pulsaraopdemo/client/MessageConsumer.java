package com.example.pulsaraopdemo.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author kmz
 * 单主题订阅，打印收到的订阅内容，不close链接
 */
@Slf4j
public class MessageConsumer {

    /**
     * 数据消费者
     */
    private Consumer consumer;

    private PulsarClient pulsarClient;


    public MessageConsumer(String topic, String subscription) {

        try {
            System.out.println("开始创建 pulsar client");
            this.pulsarClient = PulsarClient.builder()
                    .serviceUrl("pulsar://127.0.0.1:26650/")
                    .build();
            this.consumer = this.pulsarClient.newConsumer().topic(topic).subscriptionName(subscription)
                    .ackTimeout(10, TimeUnit.SECONDS).subscriptionType(SubscriptionType.Exclusive).subscribe();
        } catch (PulsarClientException e) {
            System.out.println("创建失败");
        }
    }


    public void receiveMessage() {
        /**
         * 用来异步获取，保持回话
         */
        do {
            System.out.println("================开始获取信息==========================");
            CompletableFuture<Message> msg = consumer.receiveAsync();
            try {
                System.out.printf("Message received: %s", new String(msg.get().getData()));
                consumer.acknowledge(msg.get());
            } catch (PulsarClientException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public String getMessage() {
        /**
         * 获取一次，就关闭会话
         */
        log.info("-----------------------Start get Message------------------------------------");
        CompletableFuture<Message> msg = consumer.receiveAsync();

        String result = null;

        try {
            result = "topic is: " + msg.get().getTopicName() + ",data is: " + new String(msg.get().getData());
            consumer.acknowledge(msg.get());

            consumer.close();
            pulsarClient.close();
        } catch (PulsarClientException e) {
            log.info("客户端异常",e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {

        MessageConsumer consumer = new MessageConsumer("topic1", "my-sub");
        consumer.receiveMessage();

    }
}
