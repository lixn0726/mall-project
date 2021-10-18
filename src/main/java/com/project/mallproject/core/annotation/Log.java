package com.project.mallproject.core.annotation;

import java.lang.annotation.*;

/**
 * Description: 自定义注解：组合注解，元注解+接口/变量
 * date: 2021/10/18 11:37 上午
 *
 * @author lixn
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // 一般都是RUNTIME，因为只有RUNTIME的注解才能通过反射拿到注解信息，实现自己的语义
@Documented
//@Inherited // 标记注解，说明某个注解是可以被继承的，意思就是，如果一个类上使用了一个@Inherited的注解，那么它的子类也会使用到这个注解，一般只有
/*
 * 自定义注解的用处
 *  1、搭配自定义注解处理器
 *  2、配合Spring
 */
public @interface Log {
    /*
     * 接口描述
     */
    String desc() default "";
    /*
     * [修饰符] [返回值] [属性名()] [default value + something;]
     * 返回值：
     *  基本数据类型、String、Class、enum、Annotation、数组
     */
}
