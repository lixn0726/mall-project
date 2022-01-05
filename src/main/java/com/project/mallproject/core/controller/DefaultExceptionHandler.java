package com.project.mallproject.core.controller;

import com.project.mallproject.core.model.login.ErrorMessage;
import com.project.mallproject.core.exception.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Description: 自定义异常处理器，@RestControllerAdvice意为controller增强器
 *
 * date: 2021/10/19 3:36 下午
 *
 * @author lixn
 */
@RestControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ErrorMessage handlerLoginException(CustomException e) {
        return new ErrorMessage(e.getCode(), "登陆异常：" + e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorMessage handlerRuntimeException(RuntimeException e) {
        return new ErrorMessage(1604, "运行时异常：" + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ErrorMessage handlerException(Exception e) {
        return new ErrorMessage(1605, "系统异常：" + e.getMessage());
    }
}
