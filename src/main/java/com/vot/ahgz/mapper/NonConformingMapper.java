package com.vot.ahgz.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vot.ahgz.entity.NonConforming;
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
public interface NonConformingMapper extends BaseMapper<NonConforming> {


    //获取全部数据
    List<NonConforming> getAll();

    //  根据id获取地址
    NonConforming getById(@Param("id") Integer id);

    //  根据用户名 name名称获取
    List<NonConforming> getByName(@Param("name") String name);

    //  插入用户快递
    Integer insertNonConforming(@Param("deliveryRecord") NonConforming nonConforming);

    //  根据名称删除数据
    Integer deleteByName(@Param("name") String name);

    //  更新用户数据
    NonConforming updateByName(@Param("name") String name,
                                @Param("addressList") NonConforming nonConforming);
}
