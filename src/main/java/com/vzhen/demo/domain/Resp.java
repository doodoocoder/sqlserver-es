package com.vzhen.demo.domain;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2018/10/26
 * @description 标准响应
 * @return
 */
public class Resp {
    private String code;
    private String msg;
    private long count;
    private Object data;

    public Resp() {
        this.code="200";
        this.msg="success";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
