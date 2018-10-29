package com.ssm.service;

import com.ssm.common.utils.http.ResponseModel;

/**
 * @author: Lucifer
 * @date: 2018/10/27 17:05
 * @description:
 */
public interface LoginService {

    /**
     * 发送验证码
     *
     * @param phone 手机号
     */
    void sendCode(String phone);

    /**
     * 用户登入
     *
     * @param phone    手机号码
     * @param code     验证码
     * @param password 密码
     */
    ResponseModel login(String phone, String code, String password);
}
