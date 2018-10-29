package com.ssm.common.constant;

/**
 * @author: Lucifer
 * @date: 2018/10/27 18:38
 * @description:
 */
public class Constants {

    public static final String redisLoginVerificationNum = "UserLogin";

    public static final String redisUserInfo = "redis_user";

    public static final String redisUserToken = "redis_user_token";

    //APP token有效期一个月
    public static final int APP_LOGIN_VALID = 30 * 24 * 60 * 60;

    /**
     * 登录态cookic名称
     */
    public final static String LOGIN_COOKIC_NAME = "User-Token";
}
