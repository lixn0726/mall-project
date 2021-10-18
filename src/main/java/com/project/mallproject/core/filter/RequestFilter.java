package com.project.mallproject.core.filter;

import com.project.mallproject.core.annotation.UserAuthenticate;
import com.project.mallproject.core.annotation.handler.AuthenticationHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Description: token、ticket之类的身份验证信息最好放在header里
 *              如果放在body中，如果url被劫持，很容易被仿造url来窃取个人信息
 * date: 2021/10/18 10:45 上午
 *
 * @author lixn
 */
public class RequestFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        System.out.println("method name is "+ method.getName());
        UserAuthenticate userAuthenticate = method.getAnnotation(UserAuthenticate.class);
        if (!Objects.nonNull(userAuthenticate) || !userAuthenticate.permission()) {
            System.out.println("this method has this annotation but do not need to authenticate");
            return true;
        } else {
            // todo 登陆and鉴权
            System.out.println("has annotation and need to authenticate");
            AuthenticationHandler authenticationHandler = new AuthenticationHandler();
            authenticationHandler.handle(request, response, method);
            return true;
        }
    }
}
