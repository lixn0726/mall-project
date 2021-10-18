package com.project.mallproject.core.model.coupon;

/**
 * Description:
 * date: 2021/10/18 10:35 上午
 *
 * @author lixn
 */
public class CouponDetail {
    private String description;
    private float standard;
    private float reduce;
    private String pastTime;
    private String obtainTime;

    public CouponDetail(String description, float standard, float reduce, String pastTime, String obtainTime) {
        this.description = description;
        this.standard = standard;
        this.reduce = reduce;
        this.pastTime = pastTime;
        this.obtainTime = obtainTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getStandard() {
        return standard;
    }

    public void setStandard(float standard) {
        this.standard = standard;
    }

    public float getReduce() {
        return reduce;
    }

    public void setReduce(float reduce) {
        this.reduce = reduce;
    }

    public String getPastTime() {
        return pastTime;
    }

    public void setPastTime(String pastTime) {
        this.pastTime = pastTime;
    }

    public String getObtainTime() {
        return obtainTime;
    }

    public void setObtainTime(String obtainTime) {
        this.obtainTime = obtainTime;
    }
}
