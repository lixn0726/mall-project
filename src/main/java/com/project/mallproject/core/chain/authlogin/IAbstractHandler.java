package com.project.mallproject.core.chain.authlogin;

/**
 * Description:
 * date: 2021/10/25 3:17 下午
 *
 * @author lixn
 */
public abstract class IAbstractHandler {
    protected IAbstractHandler next;

    public IAbstractHandler linkWith(IAbstractHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(String val1, String val2);

    protected boolean checkNext(String val1, String val2) {
        if (next == null) {
            return true;
        }
        return next.checkNext(val1, val2);
    }
}
