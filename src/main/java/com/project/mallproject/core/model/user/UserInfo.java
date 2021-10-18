package com.project.mallproject.core.model.user;

/**
 * Description:
 * date: 2021/10/12 5:27 下午
 *
 * @author lixn
 */
public class UserInfo {
    private int id;
    private String nickname;
    private String individualSignature;
    private String picture;
    private String qrCode;

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

    public String getIndividualSignature() {
        return individualSignature;
    }

    public void setIndividualSignature(String individualSignature) {
        this.individualSignature = individualSignature;
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
