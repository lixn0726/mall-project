package com.project.mallproject.otherdemo.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 * date: 2021/10/26 3:27 下午
 *
 * @author lixn
 */
public class WorkInvocationHandler implements InvocationHandler {
    private Object object;

    public WorkInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("object: " + object.getClass().getSimpleName());
        System.out.println("proxy: " + proxy.getClass().getSimpleName());

        if ("meeting".equals(method.getName())) {
            System.out.println("secretary should prepare material first...");
            return method.invoke(object, args);
        } else if ("evaluate".equals(method.getName())) {
            if (args[0] instanceof String) {
                if ("James".equals(args[0])) {
                    System.out.println("James made a mistake, so his grade is not so great");
                    return 70;
                }
            }
            return method.invoke(object, args);
        }
        return null;
    }
}
