package com.project.mallproject.core.chain;

import com.project.mallproject.core.common.Constant;
import com.project.mallproject.core.util.CommonUtil;

/**
 * Description:
 * date: 2021/10/25 3:38 下午
 *
 * @author lixn
 */
public class AliveHandler extends IAbstractHandler{
    @Override
    public boolean check(String userId, String userTicket) {
        String userRedis = Constant.redis.get(Constant.REDIS_USER_TOKEN + ":" + userTicket);
        if (CommonUtil.isNotNull(userRedis)) {
            return checkNext(userId, userRedis);
        }
        return false;
    }
}
