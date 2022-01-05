package com.project.mallproject.core.aspect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Description:
 * date: 2021/10/18 2:22 下午
 *
 * @author lixn
 */
@Deprecated
public class WebLog {
    private String basePath;
    private String ip;
    private Method method;
    private Parameter parameter;
    private String result;
    private Integer spendTime;
    private Integer startTime;
    private String uri;
    private String url;
}
