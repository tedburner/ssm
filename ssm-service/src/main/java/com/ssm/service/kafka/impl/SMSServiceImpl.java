package com.ssm.service.kafka.impl;

import com.ssm.common.kafka.ProduceService;
import com.ssm.common.kafka.ProduceServiceImpl;
import com.ssm.service.kafka.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author: Lucifer
 * @date: 2018/11/9 09:46
 * @description:
 */
@Service
public class SMSServiceImpl implements SMSService {

    @Autowired
    private ProduceService produceService;

    @Value(("${topic}"))
    private String topic;

    @Override
    public void sendMessage() {
        System.out.println("Value：" + topic);

        produceService.sendMessage("key", "parm");
    }
}
