package com.ssm.common.utils.http;

/**
 * @author lingjun.jlj
 * @create 2017-11-23
 **/
public enum ResponseCodeEnum {
    Success(0, "请求成功"),
    TOKEN_EXPIRED(99, "token过期"),
    LOGIN_FAIL(100,"用户请登录"),
    VERIFY_CODE_ERROR(109, "验证码错误"),
    PHONE_CODE_ERROR(110, "手机号码格式错误"),
    Fail(1000, "请求失败"),
    LOGIN_OTHER(1006, "用户已在其它设备登录"),
    ILLEGAL_TOKEN(1007, "非法的token"),

    USER_NOT_REGISTERED(2001, "用户未注销"),
    USER_PASSWORD_ERROR(2002, "用户账号密码错误"),
    Frequent_Operation(2003, "操作频繁"),

    ILLEGAL_PARAM_AUTHCODE(4002, "验证码不正确"),
    ACCOUNT_REGISTERED(4003, "账号已经注册"),
    USER_NOT_EXIST(4004, "用户不存在"),
    AUTHCODE_TIME_OUT(4005, "验证码超时"),
    USER_NOT_ACTIVED(4006, "用户未激活"),
    ILLEGAL_PASSWORD(4008, "密码错误"),
    DIRTY_WORD(4009, "脏词"),
    PARAMETER_ERROR(4010, "参数异常"),
    PARAM_ERROR(4011, "参数错误"),
;


    private int code;
    private String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
