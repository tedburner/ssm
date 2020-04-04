package com.ssm.web.controller;

import com.ssm.common.aspect.AnnotationControllerCase;
import com.ssm.common.utils.http.ResponseModel;
import com.ssm.service.TestService;
import com.ssm.service.kafka.SMSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Lucifer
 * @date: 2018/11/9 09:50
 * @description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/test")
public class TestController {

    private final SMSService smsService;
    private final TestService testService;

    @Autowired
    public TestController(SMSService smsService, TestService testService) {
        this.smsService = smsService;
        this.testService = testService;
    }

    @PostMapping(value = "/send")
    public ResponseModel sendMessage() {
        ResponseModel responseModel = ResponseModel.Success();
        try {
            smsService.sendMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseModel;
    }

    @GetMapping(value = "/aop")
    @AnnotationControllerCase
    public String testAop() {
        log.info("进入controller....");
        testService.testAop();
        return "返回成功";
    }


}
