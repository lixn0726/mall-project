package com.project.mallproject.core.chain;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * date: 2021/10/20 2:31 下午
 *
 * @author lixn
 */
public abstract class IAbstractHandler {
    protected IAbstractHandler chain;

    public abstract void filtrate(HttpServletRequest request, String tmpTicket, String tmpTicketValue);

    public void setChain(IAbstractHandler chain) {
        this.chain = chain;
    }

    public IAbstractHandler getChain() {
        return this.chain;
    }
}
