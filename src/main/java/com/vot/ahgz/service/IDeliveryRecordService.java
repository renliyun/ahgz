package com.vot.ahgz.service;

import com.vot.ahgz.entity.DeliveryRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
public interface IDeliveryRecordService  {

    //获取全部数据
    List<DeliveryRecord> getAll();

    //  根据id获取地址
    DeliveryRecord getById( Integer id);

    //  根据用户名 name名称获取
    List<DeliveryRecord> getByName(String name);

    //  插入用户快递
    Integer insertDeliveryRecord( DeliveryRecord deliveryRecord);

    //  根据名称删除数据
    Integer deleteByName( String name);

    //  根据名称删除数据
    Integer deleteById( Integer id);

    //  更新用户数据
    Integer updateByName( DeliveryRecord deliveryRecord);

}
