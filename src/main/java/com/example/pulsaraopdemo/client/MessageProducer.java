package com.example.pulsaraopdemo.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * 测试使用的消息生产者
 * @author kmz
 */
@Slf4j
public class MessageProducer {

    @Autowired
    private PulsarClient pulsarClient;

    private Producer<byte[]> producer;

    public MessageProducer(String topic) {
        try {
            this.producer = this.pulsarClient.newProducer(Schema.BYTES)
                    .topic(topic)
                    .batchingMaxPublishDelay(10, TimeUnit.MILLISECONDS)
                    .sendTimeout(10, TimeUnit.SECONDS)
                    .blockIfQueueFull(true)
                    .create();
        } catch (PulsarClientException e) {
            log.info("producer create fail", e);
        }
    }

    public void sendMessage(String message) {
        producer.sendAsync(message.getBytes()).thenAccept(msgId -> {
            System.out.printf("Message with ID %s successfully sent", msgId);
        });

    }

    public void sendOnce(String message) {
        /**
         * 发送一次就关闭
         */
        try {
            sendMessage(message);
            close(producer);
            pulsarClient.close();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
    }

    public void close(Producer<byte[]> producer) {
        producer.closeAsync()
                .thenRun(() -> System.out.println("Producer closed"));
    }

    public static void main(String[] args) {

        MessageProducer producer = new MessageProducer("topic1");

        producer.sendOnce("Hello World ,hahahahahahahahahaa");
    }
}
