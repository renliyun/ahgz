package com.vot.ahgz.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vot.ahgz.entity.InRecord;
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
public interface InRecordMapper extends BaseMapper<InRecord> {

    //获取全部数据
    List<InRecord> getAll();

    //  根据id获取地址
    InRecord getById(@Param("id") Integer id);

    //  根据用户名 name名称获取
    List<InRecord> getByName(@Param("name") String name);

    //  插入用户快递
    Integer insertInRecord(@Param("deliveryRecord") InRecord inRecord);

    //  根据名称删除数据
    Integer deleteByName(@Param("name") String name);

    //  更新用户数据
    InRecord updateByName(@Param("name") String name,
                                @Param("addressList") InRecord inRecord);
}
