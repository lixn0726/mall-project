package com.project.mallproject.core.chain;

import com.project.mallproject.core.enums.ErrorCode;
import com.project.mallproject.core.exception.CustomException;
import com.project.mallproject.core.util.EncryptUtil;

import static com.project.mallproject.core.common.Constant.MD5;

/**
 * Description:
 * date: 2021/10/20 10:33 上午
 *
 * @author lixn
 */
public class TmpTicketDispenser implements DispenseChain{
    private DispenseChain dispenseChain;

    @Override
    public void setNextChain(DispenseChain chain) {
        this.dispenseChain = chain;
    }

    @Override
    public void dispense(String tmpTicketValue, String tmpTicket) {
        if (tmpTicketValue.equals(EncryptUtil.encrypt(tmpTicket, MD5))) {
            this.dispenseChain.dispense(tmpTicketValue, tmpTicket);
        } else {
            throw new CustomException(ErrorCode.ERROR_TICKET);
        }
    }
}
