package com.project.mallproject.aop;

import com.project.mallproject.aop.bean.IUserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lixn
 * date: 2021/12/22 4:57 下午
 * <p>
 * Description:
 */
public class Demo {
    public static void main(String[] args) {
//        IUserService service = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
//                new Class[]{IUserService.class},
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("你被代理了！");
//                        return null;
//                    }
//                });
//        System.out.println("测试结果：");
//        service.queryInfo();
        System.out.println("I am testing jclasslib");
    }
}
