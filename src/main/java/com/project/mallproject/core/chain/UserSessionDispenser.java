package com.project.mallproject.core.chain;

import com.project.mallproject.core.enums.ErrorCode;
import com.project.mallproject.core.exception.CustomException;
import com.project.mallproject.core.util.CommonUtil;

import static com.project.mallproject.core.common.Constant.REDIS_USER_TOKEN;
import static com.project.mallproject.core.common.Constant.redis;

/**
 * Description:
 * date: 2021/10/20 10:39 上午
 *
 * @author lixn
 */
public class UserSessionDispenser implements DispenseChain{
    private DispenseChain dispenseChain;

    @Override
    public void setNextChain(DispenseChain chain) {
        this.dispenseChain = chain;
    }

    @Override
    public void dispense(String tmpTicketValue, String tmpTicket) {
        String userId = redis.get(REDIS_USER_TOKEN);
        String userRedis = redis.get(REDIS_USER_TOKEN + ":" + userId);
        if (!CommonUtil.isNotNull(userRedis)) {
            this.dispenseChain.dispense(tmpTicketValue, tmpTicket);
        } else {
            throw new CustomException(ErrorCode.ERROR_TICKET);
        }
    }
}
