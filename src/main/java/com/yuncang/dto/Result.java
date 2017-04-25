package com.yuncang.dto;

/**
 * Created by lzw on 2017/4/23.
 * 所有的ajax请求返回类型，封装json结果
 */
public class Result<T> {
    private boolean success;
    private T data;
    private String errorinfo;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, String errorinfo) {
        this.success = success;
        this.errorinfo = errorinfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorinfo() {
        return errorinfo;
    }

    public void setErrorinfo(String errorinfo) {
        this.errorinfo = errorinfo;
    }
}
