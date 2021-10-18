package com.project.mallproject.core.model.login;

/**
 * Description: 没决定是否要用
 * date: 2021/10/18 5:15 下午
 *
 * @author lixn
 */
public class MySession {
    private String sessionId;
    private String domain;
    private final String path = "/";
    private LoginMessage message;
    private boolean isOnline;
}
