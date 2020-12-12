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

public class NonConforming implements Serializable {

    private static final long serialVersionUID = 1L;

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

    //  操作者
    private String operator;

    //  操作时间
    private LocalDateTime operationTime;

    //  备注
    private String mark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonConforming that = (NonConforming) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(partName, that.partName) &&
                Objects.equals(category, that.category) &&
                Objects.equals(partSpecification, that.partSpecification) &&
                Objects.equals(material, that.material) &&
                Objects.equals(figureNumber, that.figureNumber) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(location, that.location) &&
                Objects.equals(operator, that.operator) &&
                Objects.equals(operationTime, that.operationTime) &&
                Objects.equals(mark, that.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partName, category, partSpecification, material, figureNumber, quantity, location, operator, operationTime, mark);
    }

    public NonConforming() {
    }

    public NonConforming(Integer id, String partName, String category, String partSpecification, String material, String figureNumber, Long quantity, String location, String operator, LocalDateTime operationTime, String mark) {
        this.id = id;
        this.partName = partName;
        this.category = category;
        this.partSpecification = partSpecification;
        this.material = material;
        this.figureNumber = figureNumber;
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
        return "NonConforming{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", category='" + category + '\'' +
                ", partSpecification='" + partSpecification + '\'' +
                ", material='" + material + '\'' +
                ", figureNumber='" + figureNumber + '\'' +
                ", quantity=" + quantity +
                ", location='" + location + '\'' +
                ", operator='" + operator + '\'' +
                ", operationTime=" + operationTime +
                ", mark='" + mark + '\'' +
                '}';
    }
}
