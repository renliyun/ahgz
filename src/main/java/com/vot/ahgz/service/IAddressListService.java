package com.vot.ahgz.service;

import com.vot.ahgz.entity.AddressList;
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
public interface IAddressListService  {

    //获取全部数据
    List<AddressList> getAll();

    //  根据用户名 name名称获取
    AddressList getOne( Integer  id);

    //  根据用户名 name名称获取
    List<AddressList> getByName( String name);

    //  插入用户快递
    Integer insertAddressList( AddressList addressList);

    //  根据名称删除数据
    Integer deleteByName( String name);

    //  更新用户数据
    AddressList updateByName(AddressList addressList);

}
