package com.vot.ahgz.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vot.ahgz.entity.OutRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
@Repository
public interface OutRecordMapper extends BaseMapper<OutRecord> {

    //获取全部数据
    List<OutRecord> getAll();

    //  根据id获取地址
    OutRecord getById(@Param("id") Integer id);

    //  根据用户名 name名称获取
    List<OutRecord> getByName(@Param("name") String name);

    //  插入用户快递
    Integer insertOutRecord(@Param("deliveryRecord") OutRecord outRecord);

    //  根据名称删除数据
    Integer deleteByName(@Param("name") String name);

    //  更新用户数据
    OutRecord updateByName(@Param("name") String name,
                                @Param("addressList") OutRecord outRecord);
}
