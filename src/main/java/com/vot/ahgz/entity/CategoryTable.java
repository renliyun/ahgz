package com.vot.ahgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * <p>
 * 
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */

public class CategoryTable extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 6695126616117377921L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //  类别名称
    private String name;

    // 备注
    private String mark;

    public CategoryTable(String createdName, LocalDate createdTime, String updatedName, LocalDate updateTime, Integer id, String name, String mark) {
        super(createdName, createdTime, updatedName, updateTime);
        this.id = id;
        this.name = name;
        this.mark = mark;
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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "CategoryTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark='" + mark + '\'' +
                "} " + super.toString();
    }
}
