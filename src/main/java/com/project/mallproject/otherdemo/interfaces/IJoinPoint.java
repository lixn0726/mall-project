package com.project.mallproject.otherdemo.interfaces;

import org.aspectj.bridge.SourceLocation;
import org.aspectj.lang.JoinPoint;
import sun.reflect.generics.tree.Signature;

/**
 * Description:
 * date: 2021/10/26 9:25 上午
 *
 * @author lixn
 */
public interface IJoinPoint {
    String toString(); // 连接点所在位置的相关信息
    String toShortString(); // 连接点所在位置的简短信息
    String toLongString(); // ...全部信息
    Object getThis(); // 返回AOP代理对象
    Object getTarget(); // 返回目标对象
    Object[] getArgs(); // 返回被通知方法的参数列表
    Signature getSignature();
    SourceLocation getSourceLocation();
    String getKind();
    JoinPoint.StaticPart getStaticPart();
}
