package com.project.mallproject.core.annotation;

/**
 * Description:
 * date: 2021/10/25 5:39 下午
 *
 * @author lixn
 */
public class SysLogBo {
    private String className;
    private String methodName;
    private String params;
    private Long execTime;
    private String remark;
    private String createDate;

    @Override
    public String toString() {
        return "SysLogBo{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", params='" + params + '\'' +
                ", execTime=" + execTime +
                ", remark='" + remark + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

    public SysLogBo(String className, String methodName, String params, Long execTime, String remark, String createDate) {
        this.className = className;
        this.methodName = methodName;
        this.params = params;
        this.execTime = execTime;
        this.remark = remark;
        this.createDate = createDate;
    }

    public SysLogBo(){}

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getExecTime() {
        return execTime;
    }

    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
