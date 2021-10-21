package com.project.mallproject.core.chain;

import com.project.mallproject.core.enums.ErrorCode;
import com.project.mallproject.core.exception.CustomException;
import com.project.mallproject.core.util.CommonUtil;

import javax.servlet.http.HttpServletRequest;

import static com.project.mallproject.core.common.Constant.*;
/**
 * Description:
 * date: 2021/10/20 3:06 下午
 *
 * @author lixn
 */
public class UserAliveHandler extends IAbstractHandler{
    @Override
    public void filtrate(HttpServletRequest request, String userId, String userTicket) {
        String userRedis = redis.get(REDIS_USER_TOKEN + ":" + userTicket);
        if (!CommonUtil.isNotNull(userRedis)) {
            throw new CustomException(ErrorCode.ERROR_TICKET);
        }
    }
}
