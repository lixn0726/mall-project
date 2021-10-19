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
    /*
     * ticket失效三种情况，但是只需要区分两种
     *      1、ticket无效，但该用户已登陆，那么就去获取一个ticket
     *      2、ticket无效，且用户未登陆，那么就去登陆
     *      3、ticket为空，去登陆
     */
    @Override
    public boolean handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ticket = getTicketFromCookie(request, COOKIE_USER_TICKET); // 从cookie中获取这个ticket
        if (!CommonUtil.isNotNull(ticket)) {
            // ticket为空，分两种 -> 1. 该用户已登陆
            //                     2. 该用户未登陆
            String userId = redis.get(REDIS_USER_TICKET + ":" + ticket);
            if (!CommonUtil.isNotNull(userId, redis.get(REDIS_USER_TOKEN + ":" + userId))) { // 代表用户未登陆，去登陆
                String toRedirect = CommonUtil.toRedirect(request, SSO_LOGIN);
                response.sendRedirect(toRedirect);
            } else {
                String tmpTicket = CommonUtil.createTmpTicket();
//                String toRedirect = CommonUtil.toRedirect(request, ); todo 试试改一下方法
                String toRedirect = request.getRequestURL().toString() + "?ticket=" + tmpTicket;
                response.sendRedirect(toRedirect);
            }
        } else { // ticket不为空，直接去验证
            String toRedirect = CommonUtil.toRedirect(request, SSO_AUTH);
            response.sendRedirect(toRedirect);
        }
        return false;
    }

    /*
     * 从cookie中获取ticket
     */
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
}
