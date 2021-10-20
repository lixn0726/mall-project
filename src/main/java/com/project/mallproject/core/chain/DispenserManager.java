package com.project.mallproject.core.chain;

/**
 * Description:
 * date: 2021/10/20 10:45 上午
 *
 * @author lixn
 */
public class DispenserManager {
    public DispenseChain c1;

    public DispenserManager() {
        // initialize the chain
        this.c1 = new StrNotNullDispenser();
        DispenseChain c2 = new TmpTicketDispenser();
        DispenseChain c3 = new UserTicketDispenser();
        DispenseChain c4 = new UserSessionDispenser();

        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
    }
}
