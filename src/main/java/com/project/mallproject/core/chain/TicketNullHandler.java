package com.project.mallproject.core.chain;

import com.project.mallproject.core.enums.ErrorCode;
import com.project.mallproject.core.exception.CustomException;
import com.project.mallproject.core.util.CommonUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * date: 2021/10/20 2:48 下午
 *
 * @author lixn
 */
public class TicketNullHandler extends IAbstractHandler{
    @Override
    public void filtrate(HttpServletRequest request, String tmpTicket, String tmpTicketValue) {
        if (CommonUtil.isNotNull(tmpTicketValue)) {
            this.getChain().filtrate(request, tmpTicket, tmpTicketValue);
        } else {
            throw new CustomException(ErrorCode.ERROR_TICKET);
        }
    }
}
