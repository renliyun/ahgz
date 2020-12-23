package com.vot.ahgz.entity;

import java.io.Serializable;
import java.time.LocalDate;


public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2445183090385703371L;
    //  创建人
    private String createdName;

    // 创建时间
    private LocalDate createdTime;

    // 更新人
    private String updatedName;

    //  更新时间
    private LocalDate updateTime;

    public BaseEntity(String createdName, LocalDate createdTime, String updatedName, LocalDate updateTime) {
        this.createdName = createdName;
        this.createdTime = createdTime;
        this.updatedName = updatedName;
        this.updateTime = updateTime;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdName='" + createdName + '\'' +
                ", createdTime=" + createdTime +
                ", updatedName='" + updatedName + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
