package com.vot.ahgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */

public class AddressList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //  姓名
    private String name;

    //  联系方式
    private String telephone;

    //  联系地址
    private String address;

    // 备注
    private String mark;

    //  创建人
    private String createdName;

    // 创建时间
    private LocalDate createdTime;

    // 更新人
    private String updatedName;

    //  更新时间
    private LocalDate updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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
        return "AddressList{" +
        "id=" + id +
        ", name=" + name +
        ", telephone=" + telephone +
        ", address=" + address +
        ", mark=" + mark +
        ", createdName=" + createdName +
        ", createdTime=" + createdTime +
        ", updatedName=" + updatedName +
        ", updateTime=" + updateTime +
        "}";
    }
}
