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

    public static class Builder {
        private String userId;
        private String password;
        private String userInfoId;

        public Builder() {
        }

        public Builder withId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withPwd(String password) {
            this.password = password;
            return this;
        }

        public Builder withInfo(String userInfoId) {
            this.userInfoId = userInfoId;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.password = builder.password;
        this.userInfoId = builder.userInfoId;
    }

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
