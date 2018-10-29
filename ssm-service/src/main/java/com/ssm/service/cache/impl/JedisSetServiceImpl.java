package com.ssm.service.cache.impl;

import com.alibaba.fastjson.JSONObject;
import com.ssm.common.utils.cache.CacheUtils;
import com.ssm.model.DO.UserDO;
import com.ssm.service.cache.JedisSetService;
import com.sun.corba.se.pept.broker.Broker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Lucifer
 * @date: 2018/10/29 11:58
 * @description:
 */
@Slf4j
@Service
public class JedisSetServiceImpl implements JedisSetService {

    @Autowired
    private CacheUtils cacheUtils;

    @Override
    public String loadFPhoneForToKen(String field, String key) {

        String phone = "";
        try {
            Long ttlTime = cacheUtils.ttl(field, key);
            if (ttlTime > 0) {
                String userInfo = cacheUtils.get(field, key);
                UserDO userDO = JSONObject.toJavaObject(
                        JSONObject.parseObject(userInfo), UserDO.class);
                return userDO.getPhone();
            }
        } catch (Exception e) {
            log.error("loadFPhoneForToKen error", e);
        }

        return phone;
    }
}
