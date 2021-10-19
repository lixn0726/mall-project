package com.project.mallproject.core.annotation;

import java.lang.annotation.*;

/**
 * Description:
 * date: 2021/10/19 10:07 上午
 *
 * @author lixn
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodLog {
    String remark() default ""; // 自定义操作描述
    String operationType() default "0"; // 自定义操作类型
}
