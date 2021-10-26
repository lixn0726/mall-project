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
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.project.mallproject.core.annotation.SysLog)")
    public void logPointCut() {};

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
            saveLog(point, time);
        } catch (Exception e) {

        }
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
            sysLogBo.setRemark(sysLog.value());
        }
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLogBo.setClassName(className);
        sysLogBo.setMethodName(methodName);
        // 请求的参数
        Object[] args = point.getArgs();
        try {
            List<String> list = new ArrayList<String>();
            for (Object obj : args) {
                list.add(obj.toString()); // todo
            }
            sysLogBo.setParams(list.toString());
        } catch (Exception e) {
            sysLogService.save(sysLogBo);
        }
    }
}
