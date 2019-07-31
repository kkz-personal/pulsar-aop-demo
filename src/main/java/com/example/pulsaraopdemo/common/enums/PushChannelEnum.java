package com.example.pulsaraopdemo.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PushChannelEnum {

    TEST_CHANNEL("测试使用频道","topic1","s"),
    ;

    private String name;
    private String topic;
    private String key;


}
