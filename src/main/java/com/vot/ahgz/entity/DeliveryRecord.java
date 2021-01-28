package com.vot.ahgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.sql.Date;


/**
 * <p>
 * 
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */

public class DeliveryRecord  implements Serializable {


    private static final long serialVersionUID = 5644924281653177805L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //  物料号
    private Integer matnr;
    //  零部件名称
    private String partName;

    //  规格
    private String partSpecification;

    //  所属类别
    private String category;

    //  图号
    private String figureNumber;

    //  发货数量
    private Integer number;

    //  发货人
    private String deliveryName;

    //  发货地址
    private String deliveryAddress;

    //  发货时间
    private Date deliveryTime;

    //  收货人姓名
    private String borrowName;

    //  收货人联系方式
    private String telephone;

    //  收货供应商
    private String supplier;

    //  收获方地址
    private String borrowAddress;

    //  备注
    private String mark;

    //  创建人
    private String createdName;

    // 创建时间
    private Date createdTime;

    // 更新人
    private String updatedName;

    //  更新时间
    private Date updatedTime;

    public DeliveryRecord() {
    }

    public DeliveryRecord(Integer id, Integer matnr, String partName, String partSpecification, String category, String figureNumber, Integer number, String deliveryName, String deliveryAddress, Date deliveryTime, String borrowName, String telephone, String supplier, String borrowAddress, String mark, String createdName, Date createdTime, String updatedName, Date updatedTime) {
        this.id = id;
        this.matnr = matnr;
        this.partName = partName;
        this.partSpecification = partSpecification;
        this.category = category;
        this.figureNumber = figureNumber;
        this.number = number;
        this.deliveryName = deliveryName;
        this.deliveryAddress = deliveryAddress;
        this.deliveryTime = deliveryTime;
        this.borrowName = borrowName;
        this.telephone = telephone;
        this.supplier = supplier;
        this.borrowAddress = borrowAddress;
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

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }



    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getBorrowAddress() {
        return borrowAddress;
    }

    public void setBorrowAddress(String borrowAddress) {
        this.borrowAddress = borrowAddress;
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

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "DeliveryRecord{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", partSpecification='" + partSpecification + '\'' +
                ", category='" + category + '\'' +
                ", figureNumber='" + figureNumber + '\'' +
                ", number=" + number +
                ", deliveryName='" + deliveryName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", borrowName='" + borrowName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", supplier='" + supplier + '\'' +
                ", borrowAddress='" + borrowAddress + '\'' +
                ", mark='" + mark + '\'' +
                ", createdName='" + createdName + '\'' +
                ", createdTime=" + createdTime +
                ", updatedName='" + updatedName + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
