package com.ssm.common.kafka;

import org.springframework.stereotype.Service;

/**
 * @author: Lucifer
 * @date: 2018/11/8 22:54
 * @description:
 */
@Service
public class ProduceServiceImpl implements ProduceService {

    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public void sendMessage(String key, Object msgBody) {
        System.out.println("topic:" + this.getTopic());
    }
}
