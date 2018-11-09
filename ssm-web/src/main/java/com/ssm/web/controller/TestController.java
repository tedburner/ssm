package com.ssm.web.controller;

import com.ssm.common.utils.http.ResponseModel;
import com.ssm.service.kafka.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Lucifer
 * @date: 2018/11/9 09:50
 * @description:
 */
@RestController
@RequestMapping(value = "/user/test/")
public class TestController {

    @Autowired
    private SMSService smsService;

    @PostMapping(value = "send")
    public ResponseModel sendMessage() {
        ResponseModel responseModel = ResponseModel.Success();
        try {
            smsService.sendMessage();
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseModel;
    }
}
