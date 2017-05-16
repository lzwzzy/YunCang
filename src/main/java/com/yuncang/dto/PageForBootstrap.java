package com.yuncang.dto;

/**
 * Created by lzw on 2017/5/13.
 * 封装返回前端bootstrapTable的json数据
 */
public class PageForBootstrap<T> {
    private int total;//总记录数
    private T rows;//分页后的数据
    private boolean success;//数据获取成功与否标志
    private String errorInfo;//失败信息

    public PageForBootstrap(boolean success, int total, T rows) {
        this.total = total;
        this.rows = rows;
        this.success = success;
    }

    public PageForBootstrap(boolean success, String errorInfo) {
        this.success = success;
        this.errorInfo = errorInfo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
