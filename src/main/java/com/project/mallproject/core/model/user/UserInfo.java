package com.project.mallproject.core.model.user;

import com.project.mallproject.core.enums.AuthorityType;

/**
 * Description:
 * date: 2021/10/12 5:27 下午
 *
 * @author lixn
 */
public class UserInfo {
    private int id;
    private String nickname;
    private String signature;
    private String picture;
    private String qrCode;
    private AuthorityType authority;

    public AuthorityType getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityType authority) {
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getsignature() {
        return signature;
    }

    public void setsignature(String signature) {
        this.signature = signature;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
