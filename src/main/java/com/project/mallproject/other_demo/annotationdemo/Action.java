package com.project.mallproject.other_demo.annotationdemo;

import java.lang.annotation.*;

/**
 * Description:
 * date: 2021/10/18 2:08 下午
 *
 * @author lixn
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    public String action() default "0";
}
