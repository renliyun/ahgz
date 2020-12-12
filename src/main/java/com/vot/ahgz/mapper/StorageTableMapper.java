package com.vot.ahgz.mapper;



import com.vot.ahgz.entity.StorageTable;
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
public interface StorageTableMapper {


    //获取全部数据
    List<StorageTable> getAll();

    //  根据id获取地址
    StorageTable getById(@Param("id") Integer id);

    //  根据用户名 name名称获取
    List<StorageTable> getByName(@Param("name") String name);

    //  插入用户快递
    Integer insertStorageTable(@Param("deliveryRecord") StorageTable storageTable);

    //  根据名称删除数据
    Integer deleteByName(@Param("name") String name);

    //  更新用户数据
    StorageTable updateByName(@Param("name") String name,
                                @Param("addressList") StorageTable storageTable);
}
