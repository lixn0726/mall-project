package com.project.mallproject.otherdemo.proxy.dynamicproxy;

import com.project.mallproject.otherdemo.proxy.staticproxy.IWork;
import com.project.mallproject.otherdemo.proxy.staticproxy.Leader;

import java.lang.reflect.Proxy;

/**
 * Description:
 * date: 2021/10/26 3:30 下午
 *
 * @author lixn
 */
public class TestApp {
    public static void main(String[] args) throws Throwable{
        /*
        Leader leader = new Leader();
        IWork proxy = (IWork) Proxy.newProxyInstance(Leader.class.getClassLoader(),
                new Class[]{IWork.class}, new WorkInvocationHandler(leader)); // 通过JVM生成代理对象，而不是new，代理方法统一为invoke
        proxy.meeting();
        proxy.evaluate("James");
        proxy.evaluate("Joy");
         */

        IWork worker = (IWork) Proxy.newProxyInstance(Leader.class.getClassLoader(), new Class[]{IWork.class},
                new WorkHandler(new IWork() {
                    @Override
                    public void meeting() {
                        return;
                    }

                    @Override
                    public int evaluate(String name) {
                        return 0;
                    }

                    @Override
                    public IWork work(String subject) {
                        return null;
                    }
                }));
        worker.work("AAA").work("BBB").work("CCC");
    }
}
