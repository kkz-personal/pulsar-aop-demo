package test;

import com.example.pulsaraopdemo.PulsarAopDemoApplication;
import com.example.pulsaraopdemo.client.MessageConsumer;
import com.example.pulsaraopdemo.client.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PulsarAopDemoApplication.class)
@Slf4j
public class PulsarTest {

    @Autowired
    PulsarClient client;

    @Test
    public void test1(){
        try {
            client.newConsumer().topic("topic1").subscriptionName("my-sub")
                    .ackTimeout(10, TimeUnit.SECONDS).subscriptionType(SubscriptionType.Exclusive).subscribe();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){

    }

    @Test
    public void test3(){
        MessageConsumer consumer = new MessageConsumer("topic1", "my-sub");
        MessageProducer producer = new MessageProducer("topic1");

        producer.sendOnce("Hello World ,hahahahahahahahahaa");
      //  consumer.receiveMessage();
        consumer.getMessage();
    }

}
