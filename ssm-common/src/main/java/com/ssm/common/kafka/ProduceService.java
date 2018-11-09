package com.ssm.common.kafka;

/**
 * @author: Lucifer
 * @date: 2018/11/8 22:54
 * @description: 消息队列生产者统一接口
 */
public interface ProduceService {

    void sendMessage(String key, Object msgBody);
}
