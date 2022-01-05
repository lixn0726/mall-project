package com.project.mallproject.core.chain.authlogin;

import com.project.mallproject.core.util.CommonUtil;

/**
 * Description:
 * date: 2021/10/25 3:24 下午
 *
 * @author lixn
 */
public class NotNullHandler extends IAbstractHandler{

    @Override
    public boolean check(String tmpTicket, String tmpTicketValue) {
        if (!CommonUtil.isNotNull(tmpTicketValue)) {
            return false;
        }
        return checkNext(tmpTicket, tmpTicketValue);
    }
}
