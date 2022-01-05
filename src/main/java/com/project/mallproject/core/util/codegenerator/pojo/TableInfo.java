package com.project.mallproject.core.util.codegenerator.pojo;

import java.util.List;

/**
 * Description:
 * date: 2021/10/26 5:27 下午
 *
 * @author lixn
 */
public class TableInfo {
    private String name;
    private String comment = "";
    private List<TableField> fields;

    public TableInfo(String name, String comment, List<TableField> fields) {
        this.name = name;
        this.comment = comment;
        this.fields = fields;
    }

    public TableInfo() {
    }

    // ------ getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<TableField> getFields() {
        return fields;
    }

    public void setFields(List<TableField> fields) {
        this.fields = fields;
    }
}
