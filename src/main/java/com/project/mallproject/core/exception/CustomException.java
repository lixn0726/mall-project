package com.project.mallproject.core.exception;

import com.project.mallproject.core.enums.ErrorCode;

/**
 * Description:
 * date: 2021/10/19 3:24 下午
 *
 * @author lixn
 */
public class CustomException extends RuntimeException{
    private Integer code;
    private String message;

    public CustomException() {

    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /*
     * 通过错误枚举类来定义异常
     */
    public CustomException(ErrorCode errorCode) {
        this.message = errorCode.getMsg();
        this.code = errorCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
