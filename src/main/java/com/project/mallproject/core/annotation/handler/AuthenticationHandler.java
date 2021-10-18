package com.project.mallproject.core.annotation.handler;

import com.project.mallproject.core.common.Constant;
import com.project.mallproject.core.util.CommonUtil;
import org.springframework.core.annotation.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Description: 需要进行鉴权
 * date: 2021/10/18 2:43 下午
 *
 * @author lixn
 */
public class AuthenticationHandler implements BasicHandler {
    private final Constant constant = new Constant();
    @Override
    public boolean handle(HttpServletRequest request, HttpServletResponse response, Method method) throws IOException {
        String ticket = request.getHeader("ticket");
        if (CommonUtil.isNotNull(ticket)) {
            System.out.println("I got the ticket, its value is " + ticket);
            String toRedirect = "http://localhost:8081/sso/auth?ticket=" +
                    ticket;
            response.sendRedirect(toRedirect);
        } else {
            String username = request.getParameter("username");
            String pwd = request.getParameter("pws");
            String toLogin = constant.REDIRECT_TO_LOGIN + "username=" + username + "?" + "pwd=" + pwd;
            response.sendRedirect(toLogin);
        }
        return false;
    }
}
