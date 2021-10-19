package com.project.mallproject.core.annotation.handler;

import com.project.mallproject.core.util.CommonUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.project.mallproject.core.common.Constant.*;

/**
 * Description: 需要进行鉴权
 * date: 2021/10/18 2:43 下午
 *
 * @author lixn
 */
@Component
public class AuthenticationHandler implements BasicHandler {

    @Override
    public boolean handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ticket = getTicketFromCookie(request, COOKIE_USER_TICKET); // 从cookie中获取这个ticket
        if (!verifyTicket(ticket)) {
            System.out.println("票据异常");
            return false; // todo 肯定要改的，ticket异常需要全局捕获来处理
        }
        if (CommonUtil.isNotNull(ticket)) { // 有ticket，跳去验证
            String toRedirect = CommonUtil.toRedirect(request, SSO_AUTH);
            response.sendRedirect(toRedirect);
        } else { // 没有ticket，跳去登陆
            String toLogin = CommonUtil.toRedirect(request, SSO_LOGIN);
            response.sendRedirect(toLogin);
        }
        return false;
    }

    private String getTicketFromCookie(HttpServletRequest request, String key) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || !CommonUtil.isNotNull(key)) {
            return null;
        }
        String cookieValue = null;
        for (Cookie cookie : cookieList) {
            if (cookie.getName().equals(key)) {
                cookieValue = cookie.getValue();
                break;
            }
        }
        return cookieValue;
    }

    private boolean verifyTicket(String ticket) {
        String userId = redis.get(REDIS_USER_TICKET + ":" + ticket);
        return CommonUtil.isNotNull(ticket, userId, redis.get(REDIS_USER_TOKEN + ":" + userId));
    }
}
