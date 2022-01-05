package com.project.mallproject.core.aspect;

import com.project.mallproject.core.annotation.SysLog;
import com.project.mallproject.core.annotation.SysLogBo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: 系统日志切面
 * date: 2021/10/25 5:41 下午
 *
 * @author lixn
 */

/*
 * AOP术语：
 *      1、advice通知             AOP框架的增强处理。描述了切面何时执行以及如何执行
 *      2、join point连接点       表示应用执行过程中能够插入切面的一个点，在Spring AOP中，连接点总是方法的调用
 *      3、pointcut切点           可以插入增强处理的连接点
 *      - 4、aspect切面             通知和切点的结合
 *      5、introduction引入       允许我们向现有的类添加新的方法或者属性
 *      6、weaving织入            将增强处理添加到目标对象中，并创建一个被增强的对象，这个过程就是织入
 *  AspectJ、JBOSS...Spring AOP...
 */
@Aspect // 定义为一个切面
@Component // 作为一个Spring Bean被装载
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;

    /*
     * @annotation          表示直接通过注解进行的切面，只需要在需要切面的方法上加上对应的注解就可以了
     * @args                to write
     */
    @Pointcut("@annotation(com.project.mallproject.core.annotation.SysLog)") // 对于频繁出现的相同的表达式，可以使用@Pointcut
    public void logPointCut() {}; // 声明一个切点表达式，内容和方法名都不重要，只是作为一个标识，供通知使用

    /*
     * @Around              通知方法将目标方法封装起来
     * @Before              在目标方法调用前执行
     * @After               在目标方法返回或异常后调用
     * @AfterReturning      在目标方法返回后调用
     * @AfterThrowing       在目标方法跑出异常后调用
     */
    @Around("logPointCut()") // 包裹住logPointCut() 这个方法
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed(); // 执行目标方法
        long time = System.currentTimeMillis() - beginTime;
        saveLog(point, time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLogBo sysLogBo = new SysLogBo();
        sysLogBo.setExecTime(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sysLogBo.setCreateDate(dateFormat.format(new Date()));
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if (sysLog != null) {
            // 注解上的描述
            sysLogBo.setRemark(sysLog.description() == null ? null : sysLog.description());
        }
        // 请求的类名、方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLogBo.setClassName(className);
        sysLogBo.setMethodName(methodName);
        // 请求的参数
        Object[] args = point.getArgs();
        List<String> list = new ArrayList<String>();
        for (Object obj : args) {
            list.add(obj.toString()); // todo
        }
        sysLogBo.setParams(list.toString());
        System.out.println(sysLogBo.toString());
        sysLogService.save(sysLogBo);
    }
}
