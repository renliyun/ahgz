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

public class StorageTable extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -8078691461613221658L;
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

    //  备注
    private String mark;

    public StorageTable(String createdName, LocalDate createdTime, String updatedName, LocalDate updateTime, Integer id, String partName, String category, String partSpecification, String material, String figureNumber, Integer number, String supplier, String location, String mark) {
        super(createdName, createdTime, updatedName, updateTime);
        this.id = id;
        this.partName = partName;
        this.category = category;
        this.partSpecification = partSpecification;
        this.material = material;
        this.figureNumber = figureNumber;
        this.number = number;
        this.supplier = supplier;
        this.location = location;
        this.mark = mark;
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
                ", mark='" + mark + '\'' +
                "} " + super.toString();
    }
}
