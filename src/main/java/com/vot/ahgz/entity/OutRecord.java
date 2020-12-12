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

public class OutRecord  implements Serializable{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
    private LocalDateTime receiveTime;

    //  操作者
    private String operator;

    //  操作时间
    private LocalDateTime operationTime;

    //  供货商
    private String supplier;

    //  备注
    private String mark;

    public OutRecord() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutRecord outRecord = (OutRecord) o;
        return Objects.equals(id, outRecord.id) &&
                Objects.equals(partName, outRecord.partName) &&
                Objects.equals(category, outRecord.category) &&
                Objects.equals(partSpecification, outRecord.partSpecification) &&
                Objects.equals(figureNumber, outRecord.figureNumber) &&
                Objects.equals(material, outRecord.material) &&
                Objects.equals(number, outRecord.number) &&
                Objects.equals(receiveName, outRecord.receiveName) &&
                Objects.equals(receiveTime, outRecord.receiveTime) &&
                Objects.equals(operator, outRecord.operator) &&
                Objects.equals(operationTime, outRecord.operationTime) &&
                Objects.equals(supplier, outRecord.supplier) &&
                Objects.equals(mark, outRecord.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partName, category, partSpecification, figureNumber, material, number, receiveName, receiveTime, operator, operationTime, supplier, mark);
    }

    public OutRecord(Integer id, String partName, String category, String partSpecification, String figureNumber, String material, Integer number, String receiveName, LocalDateTime receiveTime, String operator, LocalDateTime operationTime, String supplier, String mark) {
        this.id = id;
        this.partName = partName;
        this.category = category;
        this.partSpecification = partSpecification;
        this.figureNumber = figureNumber;
        this.material = material;
        this.number = number;
        this.receiveName = receiveName;
        this.receiveTime = receiveTime;
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

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public LocalDateTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(LocalDateTime receiveTime) {
        this.receiveTime = receiveTime;
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
                ", operator='" + operator + '\'' +
                ", operationTime=" + operationTime +
                ", supplier='" + supplier + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
