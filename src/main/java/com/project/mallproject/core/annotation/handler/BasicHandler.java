package com.project.mallproject.core.annotation.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Description:
 * date: 2021/10/18 2:46 下午
 *
 * @author lixn
 */
public interface BasicHandler {
    public boolean handle(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
