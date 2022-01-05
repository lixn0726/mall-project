package com.project.mallproject.core.util.codegenerator.enums;

/**
 * Description:
 * date: 2021/10/26 5:29 下午
 *
 * @author lixn
 */
public enum DatabaseType {
    MYSQL("mysql"),
    ORACLE("oracle");

    private final String value;

    private DatabaseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
