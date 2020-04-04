package com.ssm.web.controller;

import com.ssm.common.utils.http.ResponseModel;
import com.ssm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Lucifer
 * @date: 2018/10/27 17:04
 * @description:
 */
@RestController
@RequestMapping(value = "/user/")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "login")
    public ResponseModel login(HttpServletRequest request) {
        ResponseModel responseModel = ResponseModel.Success();

        responseModel.setData("123456");
        return responseModel;
    }

}
