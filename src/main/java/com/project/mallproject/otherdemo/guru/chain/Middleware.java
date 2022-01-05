package com.project.mallproject.otherdemo.guru.chain;

/**
 * @Author lixn
 * @ClassName Middleware
 * @CreateDate 2021/10/20
 * @Description
 */
public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    /**
     * subclasses will implement this method with concrete checks
     */
    public abstract boolean check(String email, String password);

    /**
     * Run check on the next object in chain or ends traversing if we're in last object in chain.
     */
    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
