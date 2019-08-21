package com.example.pulsaraopdemo.service;

import com.example.pulsaraopdemo.common.enums.PushChannelEnum;

/**
 * @author kmz
 */
public interface PushService {

    /**
     * 推送一条数据
     *
     * @param channel
     * @param id
     * @param value
     * @param args
     */
    void send(PushChannelEnum channel, Integer id, Object value, Object... args);

    /**
     * 开始
     */
    void begin();

    /**
     * 提交
     */
    void commit();

    /**
     * 回滚
     */
    void rollback();

    /**
     * 是否进行中
     *
     * @return
     */
    boolean processing();

}
