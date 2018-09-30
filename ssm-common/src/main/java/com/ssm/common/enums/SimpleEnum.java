package com.ssm.common.enums;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/30 14:59
 * @description:
 */
public enum SimpleEnum {
    ;

    private Integer code;
    private String text;

    SimpleEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
}
