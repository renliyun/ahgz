package com.vot.ahgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */

public class DeliveryRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //  零部件名称
    private String partName;

    //  规格
    private String partSpecification;

    //  所属类别
    private String category;

    //  图号
    private String figureNumber;

    //  发货数量
    private Long number;

    //  发货人
    private String deliveryName;

    //  发货地址
    private String deliveryAddress;

    //  发货时间
    private LocalDateTime deliveryTime;

    //  收货人姓名
    private String borrowName;

    //  收货地址
    private String telephone;

    //  收货供应商
    private String supplier;

    //  收获供地址
    private String borrowAddress;

    //  系统操作者
    private String operator;

    //  系统操作时间
    private LocalDateTime operationTime;

    //  备注
    private String mark;


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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
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

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }


    @Override
    public String toString() {
        return "DeliveryRecord{" +
        "id=" + id +
        ", partName=" + partName +
        ", partSpecification=" + partSpecification +
        ", category=" + category +
        ", figureNumber=" + figureNumber +
        ", number=" + number +
        ", deliveryName=" + deliveryName +
        ", deliveryAddress=" + deliveryAddress +
        ", deliveryTime=" + deliveryTime +
        ", borrowName=" + borrowName +
        ", telephone=" + telephone +
        ", supplier=" + supplier +
        ", borrowAddress=" + borrowAddress +
        ", operator=" + operator +
        ", operationTime=" + operationTime +
        ", mark=" + mark +
        "}";
    }
}
