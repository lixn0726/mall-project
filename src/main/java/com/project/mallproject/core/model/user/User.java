package com.project.mallproject.core.model.user;

/**
 * Description:
 * date: 2021/10/12 5:19 下午
 *
 * @author lixn
 */
public class User {
    private String userId;
    private String password;
    private String userInfoId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }
}
