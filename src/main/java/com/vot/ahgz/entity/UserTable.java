package com.vot.ahgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

public class UserTable extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 8768401328109881348L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //  用户名
    private String username;

    //  密码
    private String password;

    //  角色
    private String role;

    //  权限
    private String authority;

    //  备注
    private String mark;

    public UserTable(String createdName, LocalDate createdTime, String updatedName, LocalDate updateTime, Integer id, String username, String password, String role, String authority, String mark) {
        super(createdName, createdTime, updatedName, updateTime);
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.authority = authority;
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "UserTable{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", authority='" + authority + '\'' +
                ", mark='" + mark + '\'' +
                "} " + super.toString();
    }
}
