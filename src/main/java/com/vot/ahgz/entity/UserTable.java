package com.vot.ahgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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

public class UserTable implements Serializable {

    private static final long serialVersionUID = 1L;

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

    //  创建时间
    private LocalDateTime createdTime;

    //  创建人
    private String createdName;

    //  备注
    private String mark;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTable userTable = (UserTable) o;
        return Objects.equals(id, userTable.id) &&
                Objects.equals(username, userTable.username) &&
                Objects.equals(password, userTable.password) &&
                Objects.equals(role, userTable.role) &&
                Objects.equals(authority, userTable.authority) &&
                Objects.equals(createdTime, userTable.createdTime) &&
                Objects.equals(createdName, userTable.createdName) &&
                Objects.equals(mark, userTable.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role, authority, createdTime, createdName, mark);
    }

    public UserTable() {
    }

    public UserTable(Integer id, String username, String password, String role, String authority, LocalDateTime createdTime, String createdName, String mark) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.authority = authority;
        this.createdTime = createdTime;
        this.createdName = createdName;
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

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
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
        ", username=" + username +
        ", password=" + password +
        ", role=" + role +
        ", authority=" + authority +
        ", createdTime=" + createdTime +
        ", createdName=" + createdName +
        ", mark=" + mark +
        "}";
    }
}
