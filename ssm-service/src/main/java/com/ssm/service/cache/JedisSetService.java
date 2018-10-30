package com.ssm.service.cache;

/**
 * @author: Lucifer
 * @date: 2018/10/29 11:58
 * @description:
 */
public interface JedisSetService {

    /**
     * 获取toKen中保存的电话号码
     *
     * @param field
     * @param key
     */
    String loadFPhoneForToKen(String field, String key);
}
