package com.ssm.common.enums;

/**
 * @author: Lucifer
 * @date: 2018/10/26 14:38
 * @description:
 */
public enum StatusEnum {

    DELETE(0, "删除"),
    NORMAL(1, "正常");

    private Integer code;
    private String text;


    StatusEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
