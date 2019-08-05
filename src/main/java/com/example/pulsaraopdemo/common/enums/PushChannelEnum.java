package com.example.pulsaraopdemo.common.enums;

import lombok.Getter;

/**
 * @author kmz
 */
@Getter
public enum PushChannelEnum {

    TEST_CHANNEL("测试使用频道","topic1","topic1:%s"),
    ;

    PushChannelEnum(String name,String topic,String key){
        this.name = name;
        this.topic = topic;
        this.key = key;
    }

    private String name;
    private String topic;
    private String key;


}
