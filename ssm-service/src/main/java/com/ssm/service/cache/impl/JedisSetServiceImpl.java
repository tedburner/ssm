package com.ssm.service.cache.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ssm.common.utils.cache.CacheUtils;
import com.ssm.common.utils.common.FormatUtils;
import com.ssm.model.DO.UserDO;
import com.ssm.service.cache.JedisSetService;
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

    private final CacheUtils cacheUtils;

    @Autowired
    public JedisSetServiceImpl(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    @Override
    public String loadFPhoneForToKen(String field, String key) {

        String phone = "";
        try {
            Long ttlTime = cacheUtils.ttl(field, key);
            if (ttlTime > 0) {
                String userInfo = cacheUtils.get(field, key);
                TypeReference<UserDO> type = new TypeReference<UserDO>() {
                };
                UserDO userDO = FormatUtils.str2obj(userInfo, type);
                return userDO.getPhone();
            }
        } catch (Exception e) {
            log.error("loadFPhoneForToKen error", e);
        }

        return phone;
    }
}
