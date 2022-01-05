package com.project.mallproject.otherdemo.proxy.staticproxy;

import java.util.Random;

/**
 * Description:
 * date: 2021/10/26 3:19 下午
 *
 * @author lixn
 */
public class Leader implements IWork{
    @Override
    public void meeting() {
        System.out.println("leader is having a meeting...");
    }

    @Override
    public IWork work(String subject) {
        return null;
    }

    @Override
    public int evaluate(String name) {
        int score = new Random(System.currentTimeMillis()).nextInt(20) + 80;
        System.out.println("leader gave " + name + " a score " + score);
        return score;
    }
}
