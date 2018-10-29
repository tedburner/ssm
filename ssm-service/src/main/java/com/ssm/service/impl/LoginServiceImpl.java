package com.ssm.service.impl;

import com.ssm.common.constant.Constants;
import com.ssm.common.utils.cache.CacheUtils;
import com.ssm.common.utils.http.ResponseCodeEnum;
import com.ssm.common.utils.http.ResponseModel;
import com.ssm.common.utils.md5.MD5Utils;
import com.ssm.model.DO.UserDO;
import com.ssm.persist.UserMapper;
import com.ssm.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * @author: Lucifer
 * @date: 2018/10/27 17:05
 * @description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private CacheUtils cacheUtils;

    @Override
    public void sendCode(String phone) {
        Random random = new Random();
        String code = MD5Utils.selectRandom(6);
        cacheUtils.set(Constants.redisLoginVerificationNum, phone, code);
    }

    @Override
    public ResponseModel login(String phone, String code, String password) {
        Map<String, Object> dataMap = new HashMap<>();
        ResponseModel responseModel = ResponseModel.Success();

        UserDO user = userMapper.selectByPhone(phone);
        //用户不存在
        if (user == null) {
            return new ResponseModel(ResponseCodeEnum.USER_NOT_EXIST);
        }

        //验证验证码是否正确
        String verificationNum = cacheUtils.get(Constants.redisLoginVerificationNum, phone);
        if (!Objects.equals(verificationNum, code)) {
            return new ResponseModel(ResponseCodeEnum.ILLEGAL_PARAM_AUTHCODE.getCode(), "验证码不合法或无效");
        }
        StringBuilder builder = new StringBuilder();
        builder.append(Constants.redisUserInfo)
                .append("_")
                .append(phone)
                .append(MD5Utils.selectRandom(6));
        String token = MD5Utils.MD5(builder.toString());
        //设置token
        cacheUtils.set(Constants.redisUserToken, phone, token, Constants.APP_LOGIN_VALID);
        //删除旧的token
        String oldToken = cacheUtils.get(Constants.redisUserToken, phone);
        if (StringUtils.isNotBlank(oldToken)) {
            cacheUtils.del(Constants.redisUserInfo, phone);
        }
        //保存新的token
        cacheUtils.set(Constants.redisUserToken, phone, token, Constants.APP_LOGIN_VALID);
        //登入token
        dataMap.put("token", token);
        responseModel.setData(dataMap);

        //保存部分用户信息
        cacheUtils.set(Constants.redisUserInfo, token, user, Constants.APP_LOGIN_VALID);
        return responseModel;
    }

    @Override
    public void logout(String token, Long userId) {

    }
}
