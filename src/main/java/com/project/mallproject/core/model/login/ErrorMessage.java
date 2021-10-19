package com.project.mallproject.core.model.login;

import com.project.mallproject.core.enums.ErrorCode;

import java.util.Map;

/**
 * Description: 异常消息封装类
 * date: 2021/10/19 3:38 下午
 *
 * @author lixn
 */
public class ErrorMessage<T> {
    private final String msg;
    private final Integer code;
    private final boolean status;
    private T t;
    private Map map;
    private String path; // 跳转的页面url

    public ErrorMessage(ErrorCode errorCode) {
        super();
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.status = code < 1300;
    }

    public ErrorMessage(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.status = code < 1300;
    }

    public ErrorMessage(ErrorCode errorCode, T t) {
        super();
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.status = code < 1300;
        this.t = t;
    }

    public ErrorMessage(ErrorCode errorCode, T t, String path) {
        super();
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.status = code < 1300;
        this.t = t;
        this.path=path;
    }

    public ErrorMessage(ErrorCode errorCode, T t, Map map) {
        super();
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.status = code < 1300;
        this.t = t;
        this.map=map;
    }


}
