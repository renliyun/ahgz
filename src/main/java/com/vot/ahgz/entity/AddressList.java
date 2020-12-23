package com.vot.ahgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */

public class AddressList extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -15807207303869219L;

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

    /* 性别 */
    private Integer sex;

    /* 所属公司 */
    private String company;

    public AddressList(String createdName, LocalDate createdTime, String updatedName, LocalDate updateTime, Integer id, String name, String telephone, String address, String mark, Integer sex, String company) {
        super(createdName, createdTime, updatedName, updateTime);
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.mark = mark;
        this.sex = sex;
        this.company = company;
    }

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "AddressList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", mark='" + mark + '\'' +
                ", sex=" + sex +
                ", company='" + company + '\'' +
                "} " + super.toString();
    }
}
