package com.project.mallproject.otherdemo.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 * date: 2021/10/26 3:55 下午
 *
 * @author lixn
 */
public class WorkHandler implements InvocationHandler {
    private Object object;

    public WorkHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("work".equals(method.getName())) {
            System.out.println("---work: " + args[0]);
            return proxy;
        }
        return null;
    }
}
