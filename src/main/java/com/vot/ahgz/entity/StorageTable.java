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

public class StorageTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //  零部件名称
    private String partName;

    //  类别
    private String category;

    //  规格
    private String partSpecification;

    //  材料
    private String material;

    // 图号
    private String figureNumber;

    //  数量
    private Integer number;

    //  供货商
    private String supplier;

    //  库位
    private String location;

    //  更新时间
    private LocalDateTime updatedTime;

    //  跟新人
    private String updatedName;

    //  备注
    private String mark;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageTable that = (StorageTable) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(partName, that.partName) &&
                Objects.equals(category, that.category) &&
                Objects.equals(partSpecification, that.partSpecification) &&
                Objects.equals(material, that.material) &&
                Objects.equals(figureNumber, that.figureNumber) &&
                Objects.equals(number, that.number) &&
                Objects.equals(supplier, that.supplier) &&
                Objects.equals(location, that.location) &&
                Objects.equals(updatedTime, that.updatedTime) &&
                Objects.equals(updatedName, that.updatedName) &&
                Objects.equals(mark, that.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partName, category, partSpecification, material, figureNumber, number, supplier, location, updatedTime, updatedName, mark);
    }

    public StorageTable() {
    }

    public StorageTable(Integer id, String partName, String category, String partSpecification, String material, String figureNumber, Integer number, String supplier, String location, LocalDateTime updatedTime, String updatedName, String mark) {
        this.id = id;
        this.partName = partName;
        this.category = category;
        this.partSpecification = partSpecification;
        this.material = material;
        this.figureNumber = figureNumber;
        this.number = number;
        this.supplier = supplier;
        this.location = location;
        this.updatedTime = updatedTime;
        this.updatedName = updatedName;
        this.mark = mark;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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

    public String getFigureNumber() {
        return figureNumber;
    }

    public void setFigureNumber(String figureNumber) {
        this.figureNumber = figureNumber;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }


    @Override
    public String toString() {
        return "StorageTable{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", category='" + category + '\'' +
                ", partSpecification='" + partSpecification + '\'' +
                ", material='" + material + '\'' +
                ", figureNumber='" + figureNumber + '\'' +
                ", number=" + number +
                ", supplier='" + supplier + '\'' +
                ", location='" + location + '\'' +
                ", updatedTime=" + updatedTime +
                ", updatedName='" + updatedName + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
