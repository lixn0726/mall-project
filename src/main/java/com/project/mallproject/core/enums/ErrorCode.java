package com.project.mallproject.core.enums;

/**
 * Description: 自定义错误码
 * date: 2021/10/19 3:25 下午
 *
 * @author lixn
 */
public enum ErrorCode {
    SUCCESS(1200, "操作成功"),
    SUCCESS_LOGIN(1201, "登陆成功"),
    ERROR(1500, "操作失败"),
    ERROR_LOGIN(1501, "登陆失败"),
    ERROR_TOKEN(1502, "Token失效或者错误"),
    ERROR_TICKET(1503, "Ticket失效或错误"),
    ERROR_ARG(1504, "参数错误"),
    ERROR_AUTH(1505, "认证失败，没有权限"),
    ERROR_QUERY(1506, "查询失败，数据丢失");

    private final int code;
    private final String msg;

    ErrorCode(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
