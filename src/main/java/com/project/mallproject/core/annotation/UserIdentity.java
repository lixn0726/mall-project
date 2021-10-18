package com.project.mallproject.core.annotation;

import java.lang.annotation.*;

/**
 * Description: 还没想好怎么用
 * date: 2021/10/18 2:14 下午
 *
 * @author lixn
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserIdentity {
    /*
     * value of identity meanings:
     *  0 -> everyone including tourist
     *  1 -> common user that is already signed in
     *  2 -> common managers
     *  3 -> highest jurisdiction/ highest authority
     */
    public int identity() default 0;
}
