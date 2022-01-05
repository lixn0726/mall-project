package com.project.mallproject.otherdemo.aop;

import java.lang.annotation.*;

/**
 * Description:
 * date: 2021/10/26 2:51 下午
 *
 * @author lixn
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface As {
    String value() default "";
}
