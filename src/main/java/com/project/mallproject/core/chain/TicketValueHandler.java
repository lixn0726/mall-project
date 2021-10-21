package com.project.mallproject.core.chain;

import com.project.mallproject.core.enums.ErrorCode;
import com.project.mallproject.core.exception.CustomException;
import com.project.mallproject.core.util.CommonUtil;
import com.project.mallproject.core.util.EncryptUtil;
import com.project.mallproject.other_demo.chaindemo.Handler;

import javax.servlet.http.HttpServletRequest;

import static com.project.mallproject.core.common.Constant.*;
/**
 * Description:
 * date: 2021/10/20 2:56 下午
 *
 * @author lixn
 */
public class TicketValueHandler extends IAbstractHandler{
    @Override
    public void filtrate(HttpServletRequest request, String tmpTicket, String tmpTicketValue) {
        String encrypted = EncryptUtil.encrypt(tmpTicketValue, MD5);
        if (tmpTicket.equals(encrypted)) {
            this.getChain().filtrate(request, tmpTicket, tmpTicketValue);
        } else {
            throw new CustomException(ErrorCode.ERROR_TICKET);
        }
    }
}
