package com.vot.ahgz.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vot.ahgz.entity.UserTable;
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
public interface UserTableMapper extends BaseMapper<UserTable> {

    //获取全部数据
    List<UserTable> getAll();

    //  根据id获取地址
    UserTable getById(@Param("id") Integer id);

    //  根据用户名 name名称获取
    List<UserTable> getByName(@Param("name") String name);

    //  插入用户快递
    Integer insertUserTable(@Param("deliveryRecord") UserTable userTable);

    //  根据名称删除数据
    Integer deleteByName(@Param("name") String name);

    //  更新用户数据
    UserTable updateByName(@Param("name") String name,
                                @Param("addressList") UserTable userTable);

}
