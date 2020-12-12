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

public class BorrowRecord implements Serializable {

    private static final long serialVersionUID = 1L;

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

    //  系统操作人
    private String operator;

    //  系统操作时间
    private LocalDateTime operationTime;

    //  所属部门或者客户公司名称
    private String supplier;

    //  备注
    private String mark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowRecord that = (BorrowRecord) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(partName, that.partName) &&
                Objects.equals(partSpecification, that.partSpecification) &&
                Objects.equals(category, that.category) &&
                Objects.equals(material, that.material) &&
                Objects.equals(figureNumber, that.figureNumber) &&
                Objects.equals(number, that.number) &&
                Objects.equals(borrowName, that.borrowName) &&
                Objects.equals(borrowTime, that.borrowTime) &&
                Objects.equals(operator, that.operator) &&
                Objects.equals(operationTime, that.operationTime) &&
                Objects.equals(supplier, that.supplier) &&
                Objects.equals(mark, that.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partName, partSpecification, category, material, figureNumber, number, borrowName, borrowTime, operator, operationTime, supplier, mark);
    }

    public BorrowRecord() {
    }

    public BorrowRecord(Integer id, String partName, String partSpecification, String category, String material, String figureNumber, Integer number, String borrowName, LocalDateTime borrowTime, String operator, LocalDateTime operationTime, String supplier, String mark) {
        this.id = id;
        this.partName = partName;
        this.partSpecification = partSpecification;
        this.category = category;
        this.material = material;
        this.figureNumber = figureNumber;
        this.number = number;
        this.borrowName = borrowName;
        this.borrowTime = borrowTime;
        this.operator = operator;
        this.operationTime = operationTime;
        this.supplier = supplier;
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
                ", operator='" + operator + '\'' +
                ", operationTime=" + operationTime +
                ", supplier='" + supplier + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
