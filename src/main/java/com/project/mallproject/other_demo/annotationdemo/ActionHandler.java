package com.project.mallproject.other_demo.annotationdemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Description: 自定义注解要搭配注解处理器才能发挥出最大的作用
 * date: 2021/10/18 2:09 下午
 *
 * @author lixn
 */
public class ActionHandler {
    public static void action(Object obj) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Action ac = (Action) method.getAnnotation(Action.class);
            if (Objects.nonNull(ac)) {
                String result = ac.action();
                method.invoke(obj);
            }
        }
    }
}
