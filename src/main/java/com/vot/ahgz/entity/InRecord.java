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

public class InRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //  零部件名称
    private String partName;

    //  规格
    private String partSpecification;

    //  图号
    private String figureNumber;

    //  材料
    private String material;
    //  供货商
    private String supplier;

    //  所属类别
    private String category;

    //  入库数量
    private Integer quantity;

    //  库位
    private String location;

    //  操作者
    private String operator;

    //  操作时间
    private LocalDateTime operationTime;

    //  备注
    private String mark;

    public InRecord() {
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InRecord inRecord = (InRecord) o;
        return Objects.equals(id, inRecord.id) &&
                Objects.equals(partName, inRecord.partName) &&
                Objects.equals(partSpecification, inRecord.partSpecification) &&
                Objects.equals(figureNumber, inRecord.figureNumber) &&
                Objects.equals(material, inRecord.material) &&
                Objects.equals(supplier, inRecord.supplier) &&
                Objects.equals(category, inRecord.category) &&
                Objects.equals(quantity, inRecord.quantity) &&
                Objects.equals(location, inRecord.location) &&
                Objects.equals(operator, inRecord.operator) &&
                Objects.equals(operationTime, inRecord.operationTime) &&
                Objects.equals(mark, inRecord.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partName, partSpecification, figureNumber, material, supplier, category, quantity, location, operator, operationTime, mark);
    }

    public InRecord(Integer id, String partName, String partSpecification, String figureNumber, String material, String supplier, String category, Integer quantity, String location, String operator, LocalDateTime operationTime, String mark) {
        this.id = id;
        this.partName = partName;
        this.partSpecification = partSpecification;
        this.figureNumber = figureNumber;
        this.material = material;
        this.supplier = supplier;
        this.category = category;
        this.quantity = quantity;
        this.location = location;
        this.operator = operator;
        this.operationTime = operationTime;
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

    public String getFigureNumber() {
        return figureNumber;
    }

    public void setFigureNumber(String figureNumber) {
        this.figureNumber = figureNumber;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        return "InRecord{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", partSpecification='" + partSpecification + '\'' +
                ", figureNumber='" + figureNumber + '\'' +
                ", material='" + material + '\'' +
                ", supplier='" + supplier + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", location='" + location + '\'' +
                ", operator='" + operator + '\'' +
                ", operationTime=" + operationTime +
                ", mark='" + mark + '\'' +
                '}';
    }
}
