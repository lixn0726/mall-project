package com.project.mallproject.core.util.codegenerator.enums;

/**
 * Description:
 * date: 2021/10/26 5:28 下午
 *
 * @author lixn
 */
public enum CodeType {
    controller,service,serviceImpl,mapper,mapperXml,entity;

    private String type;

    public String getValue()
    {
        return this.type;
    }
}
