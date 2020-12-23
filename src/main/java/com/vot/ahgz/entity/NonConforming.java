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

public class NonConforming extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -8962143428614958813L;
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

    //  备注
    private String mark;

    public NonConforming(String createdName, LocalDate createdTime, String updatedName, LocalDate updateTime, Integer id, String partName, String category, String partSpecification, String material, String figureNumber, Long quantity, String location, String mark) {
        super(createdName, createdTime, updatedName, updateTime);
        this.id = id;
        this.partName = partName;
        this.category = category;
        this.partSpecification = partSpecification;
        this.material = material;
        this.figureNumber = figureNumber;
        this.quantity = quantity;
        this.location = location;
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
                ", mark='" + mark + '\'' +
                "} " + super.toString();
    }
}
