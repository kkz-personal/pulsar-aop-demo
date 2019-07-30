package com.example.pulsaraopdemo.client;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

public class Client {
    private PulsarClient client;

    public Client() throws PulsarClientException {
        System.out.println("--------------------------------开始创建puslar client----------------------------------");
        client = PulsarClient.builder()
                .serviceUrl("pulsar://127.0.0.1:26650/")
                .build();
        System.out.println("--------------------------------创建完成---------------------------------------------");
    }
    public void Close() throws PulsarClientException {
        client.close();
    }
    public PulsarClient getPulsarClient(){
        return client;
    }
}
