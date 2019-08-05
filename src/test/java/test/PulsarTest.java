package test;

import com.example.pulsaraopdemo.PulsarAopDemoApplication;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.SubscriptionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PulsarAopDemoApplication.class)
public class PulsarTest {

    @Autowired
    PulsarClient client;

    @Test
    public void test(){
        try {
            client.newConsumer().topic("topic1").subscriptionName("my-sub")
                    .ackTimeout(10, TimeUnit.SECONDS).subscriptionType(SubscriptionType.Exclusive).subscribe();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
    }
}
