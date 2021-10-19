package com.project.mallproject.core.model.login;

import com.project.mallproject.core.common.Constant;

/**
 * Description: 自定义类似session，保存用户登陆状态
 * date: 2021/10/18 4:59 下午
 *
 * @author lixn
 */
public class LoginMessage {
    private String loginTime;
    private String tokenValue;
    private String salt = Constant.PUBLIC_SHA;
    private String pastTime;
    private LoginMessage refresh = null;

    public LoginMessage() {
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPastTime() {
        return pastTime;
    }

    public void setPastTime(String pastTime) {
        this.pastTime = pastTime;
    }

    public LoginMessage getRefresh() {
        return refresh;
    }

    public void setRefresh(LoginMessage refresh) {
        this.refresh = refresh;
    }
}
