package com.ssm.common.utils.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @author: lingjun.jlj
 * @date: 2020/5/28 20:40
 * @description:
 */
public class FormatUtils {

    private static Logger log = LoggerFactory.getLogger(FormatUtils.class);


    /**
     * 解决java8时间冲突问题
     */
    private static final ObjectMapper objectMapper = (new ObjectMapper())
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
            //序列化结果中不包含null值
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            //允许：默认false_不解析含有结束语控制字符
            .enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature())
            //主要是这行配置，意思是在遇到未知字段时是否失败，默认为true，也就是遇到未知字段时会报错
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());

    /**
     * 对象转化成json
     *
     * @param obj 对象
     * @return json
     */
    public static <T> String obj2str(T obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("jackson obj2str error, obj={}, e={}", obj, e.getMessage());
            return null;
        }
    }

    /**
     * json 字符串转换成对象
     *
     * @param str   json 字符串
     * @param clazz 转换类型
     * @return
     */
    public static <T> T str2obj(String str, Class<T> clazz) {
        try {
            return StringUtils.isEmpty(str) ? null : objectMapper.readValue(str, clazz);
        } catch (JsonProcessingException e) {
            log.error("jackson str2obj error, str={}, e={}", str, e.getMessage());
            return null;
        }
    }

    /**
     * json 字符串转换成对象
     *
     * @param str           json 字符串
     * @param typeReference 转换类型
     * @return
     */
    public static <T> T str2obj(String str, TypeReference<T> typeReference) {
        try {
            return StringUtils.isEmpty(str) ? null : objectMapper.readValue(str, typeReference);
        } catch (JsonProcessingException e) {
            log.error("jackson str2obj error, str={}, e={}", str, e.getMessage());
            return null;
        }
    }
}
