package com.project.mallproject.core.chain;

import com.project.mallproject.core.enums.ErrorCode;
import com.project.mallproject.core.exception.CustomException;
import com.project.mallproject.core.util.CommonUtil;

/**
 * Description:
 * date: 2021/10/20 9:37 上午
 *
 * @author lixn
 */
public class StrNotNullDispenser implements DispenseChain{
    private DispenseChain dispenseChain;

    @Override
    public void setNextChain(DispenseChain chain) {
        this.dispenseChain = chain;
    }

    @Override
    public void dispense(String tmpTicketValue, String tmpTicket) {
        if (CommonUtil.isNotNull(tmpTicketValue)) {
            this.dispenseChain.dispense(tmpTicketValue, tmpTicket);
        } else {
            throw new CustomException(ErrorCode.ERROR_TICKET);
        }
    }
}
