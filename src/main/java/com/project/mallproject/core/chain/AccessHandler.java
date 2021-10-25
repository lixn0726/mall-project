package com.project.mallproject.core.chain;

import com.project.mallproject.core.common.Constant;
import com.project.mallproject.core.common.ConstantVariables;
import com.project.mallproject.core.util.CommonUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;



/**
 * Description:
 * date: 2021/10/25 3:30 下午
 *
 * @author lixn
 */
public class AccessHandler extends IAbstractHandler{
    private HttpServletRequest request;

    public AccessHandler(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public boolean check(String tmpTicket, String tmpTicketValue) {
        String userTicket = getCookie(ConstantVariables.COOKIE_USER_TICKET);
        String userId = Constant.redis.get(Constant.REDIS_USER_TICKET + ":" + userTicket);
        if (CommonUtil.isNotNull(userId)) {
            return checkNext(userId, userTicket);
        }
        return false;
    }

    private String getCookie(String key) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(key)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}

