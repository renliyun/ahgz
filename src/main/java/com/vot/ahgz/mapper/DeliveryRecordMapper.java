package com.vot.ahgz.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vot.ahgz.entity.DeliveryRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
public interface DeliveryRecordMapper  extends BaseMapper<DeliveryRecord> {

    //获取全部数据
    List<DeliveryRecord> getAll();

    //  根据id获取地址
    DeliveryRecord getById(@Param("id") Integer id);

    //  根据用户名 name名称获取
    List<DeliveryRecord> getByName(@Param("name") String name);

    //  插入用户快递
    Integer insertDeliveryRecord(@Param("deliveryRecord") DeliveryRecord deliveryRecord);

    //  根据名称删除数据
    Integer deleteByName(@Param("name") String name);

    //  更新用户数据
    DeliveryRecord updateByName(@Param("name") String name,
                             @Param("addressList") DeliveryRecord deliveryRecord);

}
