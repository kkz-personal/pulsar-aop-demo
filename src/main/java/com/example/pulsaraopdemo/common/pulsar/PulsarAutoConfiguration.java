package com.example.pulsaraopdemo.common.pulsar;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.impl.ClientBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kmz
 */
@Configuration
@EnableConfigurationProperties({PulsarClientProperties.class})
@ConditionalOnProperty(
        name = {"test.pulsar.serviceUrl"}
)
public class PulsarAutoConfiguration {

    @Autowired
    private PulsarClientProperties conf;

    public PulsarAutoConfiguration() {
    }

    @Bean
    public PulsarClient pulsarClient() throws PulsarClientException {
        return (new ClientBuilderImpl(this.conf)).build();
    }
}
