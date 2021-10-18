package com.project.mallproject.core.annotation.handler;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Description:
 * date: 2021/10/18 2:48 下午
 *
 * @author lixn
 */
public class IdentityHandler {
    public boolean handle(HttpServletRequest request, Method method) {
        return false;
    }
}
