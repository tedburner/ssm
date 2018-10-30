package com.ssm.common.utils.http;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author lingjun.jlj
 * @create 2017-11-23
 * https 数据返回包装类
 **/
public class ResponseModel<T> implements Serializable {
    private static final long serialVersionUID = -4688208407174044501L;

    private int status;
    private String info;
    private T data;
    private long timeStamp = System.currentTimeMillis();

    public static <T> ResponseModel<T> Success() {
        return new ResponseModel<>(ResponseCodeEnum.Success.getCode(), ResponseCodeEnum.Success.getMessage());
    }

    public static <T> ResponseModel<T> ParamError(String info) {
        return new ResponseModel<T>(ResponseCodeEnum.PARAMETER_ERROR.getCode(), info);
    }

    public static <T> ResponseModel<T> ParamError() {
        return new ResponseModel<T>(ResponseCodeEnum.PARAMETER_ERROR.getCode(), ResponseCodeEnum.PARAMETER_ERROR.getMessage());
    }

    public static <T> ResponseModel<T> Fail(String info) {
        return new ResponseModel<T>(ResponseCodeEnum.Fail.getCode(), StringUtils.defaultIfBlank(info, "请求失败"));
    }

    public static <T> ResponseModel<T> Fail() {
        return new ResponseModel<>(ResponseCodeEnum.Fail.getCode(), ResponseCodeEnum.Fail.getMessage());
    }

    public ResponseModel() {

    }

    public ResponseModel(int status) {
        this.status = status;
    }

    public ResponseModel(int status, String info) {
        this.info = info;
        this.status = status;
    }

    public ResponseModel(ResponseCodeEnum responseCodeEnum) {
        this.info = responseCodeEnum.getMessage();
        this.status = responseCodeEnum.getCode();
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "NewResponseModel{" +
                "status=" + status +
                ", info='" + info + '\'' +
                ", data=" + data +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
