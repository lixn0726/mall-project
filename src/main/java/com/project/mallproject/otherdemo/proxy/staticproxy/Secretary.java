package com.project.mallproject.otherdemo.proxy.staticproxy;

/**
 * Description:
 * date: 2021/10/26 3:20 下午
 *
 * @author lixn
 */
public class Secretary implements IWork{
    private Leader mLeader;

    public Secretary(Leader mLeader) {
        this.mLeader = mLeader;
    }

    @Override
    public void meeting() {
        System.out.println("secretary is preparing for a meeting...");
        mLeader.meeting();
    }

    @Override
    public IWork work(String subject) {
        return null;
    }

    @Override
    public int evaluate(String name) {
        System.out.println("secretary is preparing for a evaluate...");
        return mLeader.evaluate(name);
    }
}
