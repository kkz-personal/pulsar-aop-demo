package com.example.pulsaraopdemo.common.pulsar;

import org.apache.pulsar.client.impl.conf.ClientConfigurationData;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kmz
 */
@ConfigurationProperties("test.pulsar")
public class PulsarClientProperties extends ClientConfigurationData {
    public PulsarClientProperties() {

    }
}
