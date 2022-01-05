package com.project.mallproject.core.util.codegenerator.pojo;

import com.project.mallproject.core.util.codegenerator.enums.DatabaseColumnType;

/**
 * Description:
 * date: 2021/10/26 5:28 下午
 *
 * @author lixn
 */
public class TableField {
    private boolean keyFlag;
    private boolean keyIdentityFlag;
    private String name;
    private String type;
    private String propertyName;
    private DatabaseColumnType propertyType;
    private String comment;

    public TableField() {
    }

    public TableField(boolean keyFlag, boolean keyIdentityFlag, String name, String type, String propertyName, DatabaseColumnType propertyType, String comment) {
        this.keyFlag = keyFlag;
        this.keyIdentityFlag = keyIdentityFlag;
        this.name = name;
        this.type = type;
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.comment = comment;
    }

    // ------ getter and setter

    public boolean isKeyFlag() {
        return keyFlag;
    }

    public void setKeyFlag(boolean keyFlag) {
        this.keyFlag = keyFlag;
    }

    public boolean isKeyIdentityFlag() {
        return keyIdentityFlag;
    }

    public void setKeyIdentityFlag(boolean keyIdentityFlag) {
        this.keyIdentityFlag = keyIdentityFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public DatabaseColumnType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(DatabaseColumnType propertyType) {
        this.propertyType = propertyType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
