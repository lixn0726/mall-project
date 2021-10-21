package com.project.mallproject.core.chain;

import com.project.mallproject.core.enums.ErrorCode;
import com.project.mallproject.core.exception.CustomException;
import com.project.mallproject.core.util.CommonUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static com.project.mallproject.core.common.Constant.*;
/**
 * Description:
 * date: 2021/10/20 2:59 下午
 *
 * @author lixn
 */
public class TicketAccessHandler extends IAbstractHandler{
    @Override
    public void filtrate(HttpServletRequest request, String tmpTicket, String tmpTicketValue) {
        String userTicket = getCookie(request, COOKIE_USER_TICKET);
        String userId = redis.get(REDIS_USER_TICKET + ":" + userTicket);
        if (CommonUtil.isNotNull(userId)) {
            this.getChain().filtrate(request, userId, userTicket);
        } else {
            throw new CustomException(ErrorCode.ERROR_TICKET);
        }
    }

    private String getCookie(HttpServletRequest request, String key) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(key)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
