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

public class NonConforming  implements Serializable {


    private static final long serialVersionUID = -8962143428614958813L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //  零部件名称
    private String partName;

    //  所属类别
    private String category;

    //  规格
    private String partSpecification;

    //  材料
    private String material;

    //  图号
    private String figureNumber;

    //  入库数量
    private Long quantity;

    //  库位
    private String location;

    //  备注
    private String mark;

    //  创建人
    private String createdName;

    // 创建时间
    private String createdTime;

    // 更新人
    private String updatedName;

    //  更新时间
    private String updatedTime;

    public NonConforming(Integer id, String partName, String category, String partSpecification, String material, String figureNumber, Long quantity, String location, String mark, String createdName, String createdTime, String updatedName, String updatedTime) {
        this.id = id;
        this.partName = partName;
        this.category = category;
        this.partSpecification = partSpecification;
        this.material = material;
        this.figureNumber = figureNumber;
        this.quantity = quantity;
        this.location = location;
        this.mark = mark;
        this.createdName = createdName;
        this.createdTime = createdTime;
        this.updatedName = updatedName;
        this.updatedTime = updatedTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPartSpecification() {
        return partSpecification;
    }

    public void setPartSpecification(String partSpecification) {
        this.partSpecification = partSpecification;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getFigureNumber() {
        return figureNumber;
    }

    public void setFigureNumber(String figureNumber) {
        this.figureNumber = figureNumber;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    public String getupdatedTime() {
        return updatedTime;
    }

    public void setupdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "NonConforming{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", category='" + category + '\'' +
                ", partSpecification='" + partSpecification + '\'' +
                ", material='" + material + '\'' +
                ", figureNumber='" + figureNumber + '\'' +
                ", quantity=" + quantity +
                ", location='" + location + '\'' +
                ", mark='" + mark + '\'' +
                ", createdName='" + createdName + '\'' +
                ", createdTime=" + createdTime +
                ", updatedName='" + updatedName + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
