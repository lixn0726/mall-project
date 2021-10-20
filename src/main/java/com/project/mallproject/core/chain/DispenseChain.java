package com.project.mallproject.core.chain;

/**
 * Description: 责任链基类 Dispense: 分发
 * date: 2021/10/20 9:31 上午
 *
 * @author lixn
 */
public interface DispenseChain {
    void setNextChain(DispenseChain chain);

    void dispense(String tmpTicketValue, String tmpTicket);
}
