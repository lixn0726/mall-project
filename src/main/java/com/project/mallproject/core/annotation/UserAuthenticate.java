package com.project.mallproject.core.annotation;

import javax.ws.rs.NameBinding;
import java.lang.annotation.*;

/**
 * Description:
 * date: 2021/10/18 11:16 上午
 *
 * @author lixn
 */
@Target({ElementType.TYPE, ElementType.METHOD}) // 注解作用于修饰 ??
@Retention(value = RetentionPolicy.RUNTIME) // 注解生命周期
@NameBinding
@Documented // 表明这个注解应该被 javadoc工具记录
public @interface UserAuthenticate {
    /*
     * 是否需要校验访问权限，默认不需要
     */
    boolean permission() default false; // 定义一个元素
}
