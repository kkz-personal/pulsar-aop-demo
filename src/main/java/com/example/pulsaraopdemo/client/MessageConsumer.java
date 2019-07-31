package com.example.pulsaraopdemo.client;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.SubscriptionType;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author kmz
 * 单主题订阅，打印收到的订阅内容，不close链接
 */
public class MessageConsumer {
    private Client client;
    private Consumer consumer;

    public MessageConsumer(String topic, String subscription) throws PulsarClientException {
        client = new Client();
        consumer = createConsumer(topic, subscription);
    }

    private Consumer createConsumer(String topic, String subscription) throws PulsarClientException {

        return client.getPulsarClient().newConsumer().topic(topic).subscriptionName(subscription)
                .ackTimeout(10, TimeUnit.SECONDS).subscriptionType(SubscriptionType.Exclusive).subscribe();
    }

    public void receiveMessage() throws ExecutionException, InterruptedException, PulsarClientException {
        /**
         * 用来异步获取，保持回话
         */
        do {
            CompletableFuture<Message> msg = consumer.receiveAsync();

            System.out.printf("Message received: %s", new String(msg.get().getData()));

            consumer.acknowledge(msg.get());
        } while (true);
    }

    public String getMessage() throws ExecutionException, InterruptedException, PulsarClientException {
        /**
         * 获取一次，就关闭会话
         */
        System.out.printf("Start pulsar");
        CompletableFuture<Message> msg = consumer.receiveAsync();

        String result = "topic is: " + msg.get().getTopicName() + ",data is: " + new String(msg.get().getData());

        consumer.acknowledge(msg.get());
        consumer.close();
        client.Close();
        return result;
    }

    public static void main(String[] args) throws PulsarClientException, ExecutionException, InterruptedException {
        MessageConsumer consumer = new MessageConsumer("topic1", "my-sub");
        consumer.receiveMessage();

    }
}
