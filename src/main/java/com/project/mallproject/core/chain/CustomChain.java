package com.project.mallproject.core.chain;

import java.util.List;

/**
 * Description:
 * date: 2021/10/20 3:06 下午
 *
 * @author lixn
 */
public class CustomChain {
    private IAbstractHandler head;

    public CustomChain() {
        head = new TicketNullHandler();
        IAbstractHandler second = new TicketValueHandler();
        IAbstractHandler third = new TicketAccessHandler();
        IAbstractHandler last = new UserAliveHandler();

        head.setChain(second);
        second.setChain(third);
        third.setChain(last);
    }

    public IAbstractHandler getHead() {
        return head;
    }

    public void setHead(IAbstractHandler head) {
        this.head = head;
    }
}
