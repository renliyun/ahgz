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

public class BorrowRecord extends BaseEntity  implements Serializable {


    private static final long serialVersionUID = -3683524450621282446L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //  零部件名称
    private String partName;

    //  规格
    private String partSpecification;

    //  所属类别
    private String category;

    //  材料
    private String material;

    //  图号
    private String figureNumber;

    //  数量
    private Integer number;

    //  借用人
    private String borrowName;

    //  借用时间
    private LocalDateTime borrowTime;

    //  所属部门或者客户公司名称
    private String supplier;

    //  备注
    private String mark;

    public BorrowRecord(String createdName, LocalDate createdTime, String updatedName, LocalDate updateTime, Integer id, String partName, String partSpecification, String category, String material, String figureNumber, Integer number, String borrowName, LocalDateTime borrowTime, String supplier, String mark) {
        super(createdName, createdTime, updatedName, updateTime);
        this.id = id;
        this.partName = partName;
        this.partSpecification = partSpecification;
        this.category = category;
        this.material = material;
        this.figureNumber = figureNumber;
        this.number = number;
        this.borrowName = borrowName;
        this.borrowTime = borrowTime;
        this.supplier = supplier;
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

    public String getPartSpecification() {
        return partSpecification;
    }

    public void setPartSpecification(String partSpecification) {
        this.partSpecification = partSpecification;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public LocalDateTime getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(LocalDateTime borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", partSpecification='" + partSpecification + '\'' +
                ", category='" + category + '\'' +
                ", material='" + material + '\'' +
                ", figureNumber='" + figureNumber + '\'' +
                ", number=" + number +
                ", borrowName='" + borrowName + '\'' +
                ", borrowTime=" + borrowTime +
                ", supplier='" + supplier + '\'' +
                ", mark='" + mark + '\'' +
                "} " + super.toString();
    }
}
