package com.vot.ahgz.mapper;


import com.vot.ahgz.entity.AddressList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
public interface AddressListMapper {

    //获取全部数据
    List<AddressList> getAll();



    //  根据用户名 name名称获取
    List<AddressList> getByName(@Param("name") String name);

    //  插入用户快递
    Integer insertAddressList(@Param("addressList") AddressList addressList);

    //  根据名称删除数据
    Integer deleteByName(@Param("name") String name);

    //  更新用户数据   不允许用户更改姓名----
    AddressList updateByName(@Param("name") String name,
                             @Param("addressList") AddressList addressList);


}
