package com.project.mallproject.core.annotation;

import java.lang.annotation.*;

/**
 * Description: 定义系统日志注解
 * date: 2021/10/25 5:38 下午
 *
 * @author lixn
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
