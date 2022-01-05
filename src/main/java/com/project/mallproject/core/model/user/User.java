package com.project.mallproject.core.model.user;

/**
 * Description:
 * date: 2021/10/12 5:19 下午
 *
 * @author lixn
 */

public class User {
    private String id;
    private String password;
    private String userInfoId;

    public static class Builder {
        private String id;
        private String password;
        private String userInfoId;

        public Builder() {
        }

        public Builder withId(String id) {
            this.id = id;
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

    public User(Builder builder) {
        this.id = builder.id;
        this.password = builder.password;
        this.userInfoId = builder.userInfoId;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
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
