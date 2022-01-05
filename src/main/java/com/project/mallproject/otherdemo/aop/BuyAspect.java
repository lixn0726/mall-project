package com.project.mallproject.otherdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * Description: question: 为什么直接跑就不生效，跑application的时候就生效了
 *
 * date: 2021/10/26 11:31 上午
 *
 * @author lixn
 */
@Aspect
@Configuration
public class BuyAspect {

    /*
     * execution(* com.project.mallproject.other_demo.aop.IBuy.buy(..))
     * execution expression:
     *          *: 方法的返回值类型，*表示全部
     *          com...buy: 定义切面的切点
     *          ..: 表示任意的buy()方法，不论入参是什么
     * 多个匹配之间使用 &&、||、! 来表示且、或、非
     */

//    @Before("execution(* com.project.mallproject.other_demo.aop.IBuy.buy(..))")
//    public void hehe() {
//        System.out.println("before...");
//    }
//
//    @After("execution(* com.project.mallproject.other_demo.aop.IBuy.buy(..))")
//    public void haha() {
//        System.out.println("after...");
//    }
//
//    @AfterReturning("execution(* com.project.mallproject.other_demo.aop.IBuy.buy(..))")
//    public void xixi() {
//        System.out.println("after returning...");
//    }
//
//    @Around("execution(* com.project.mallproject.other_demo.aop.IBuy.buy(..))")
//    public void xxx(ProceedingJoinPoint point) {
//        try {
//            System.out.println("around method...");
//            point.proceed();
//            System.out.println("method is running...");
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }

    @Pointcut("@annotation(com.project.mallproject.otherdemo.aop.As)")
    public void gif() {}

    @Around(value = "gif()")
    public String hehe(ProceedingJoinPoint point){
        System.out.println("hehe");
        return "切面消费完咯";
    }
}
