package com.ssm.web.controller;

import com.ssm.common.utils.http.ResponseModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Lucifer
 * @date: 2018/10/30 17:20
 * @description:
 */
@RestController
@RequestMapping("/apollo/")
public class ApolloController {


    @Value("${timeout}")
    private Integer timeout;

    @GetMapping(value = "timeout")
    public ResponseModel timeout() {
        ResponseModel responseModel = ResponseModel.Success();
        responseModel.setData("获取超时时间：" + String.valueOf(timeout));
        return responseModel;
    }
}
