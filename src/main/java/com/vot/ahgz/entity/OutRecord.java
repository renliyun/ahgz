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

public class OutRecord  implements Serializable{


    private static final long serialVersionUID = -2685902298254662333L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //  物料号
    private Integer matnr;

    //  零部件名称
    private String partName;

    //  所属类别
    private String category;

    //  规格
    private String partSpecification;

    //  图号
    private String figureNumber;

    //  材料
    private String material;

    //  领用数量
    private Integer number;

    //  领用人
    private String receiveName;

    //  领用时间
    private String receiveTime;

    //  供货商
    private String supplier;

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

    public OutRecord() {
    }

    public OutRecord(Integer id, Integer matnr, String partName, String category, String partSpecification, String figureNumber, String material, Integer number, String receiveName, String receiveTime, String supplier, String mark, String createdName, String createdTime, String updatedName, String updatedTime) {
        this.id = id;
        this.matnr = matnr;
        this.partName = partName;
        this.category = category;
        this.partSpecification = partSpecification;
        this.figureNumber = figureNumber;
        this.material = material;
        this.number = number;
        this.receiveName = receiveName;
        this.receiveTime = receiveTime;
        this.supplier = supplier;
        this.mark = mark;
        this.createdName = createdName;
        this.createdTime = createdTime;
        this.updatedName = updatedName;
        this.updatedTime = updatedTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getMatnr() {
        return matnr;
    }

    public void setMatnr(Integer matnr) {
        this.matnr = matnr;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
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
        return "OutRecord{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", category='" + category + '\'' +
                ", partSpecification='" + partSpecification + '\'' +
                ", figureNumber='" + figureNumber + '\'' +
                ", material='" + material + '\'' +
                ", number=" + number +
                ", receiveName='" + receiveName + '\'' +
                ", receiveTime=" + receiveTime +
                ", supplier='" + supplier + '\'' +
                ", mark='" + mark + '\'' +
                ", createdName='" + createdName + '\'' +
                ", createdTime=" + createdTime +
                ", updatedName='" + updatedName + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
