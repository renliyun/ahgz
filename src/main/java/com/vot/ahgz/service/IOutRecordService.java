package com.vot.ahgz.service;

import com.vot.ahgz.entity.OutRecord;
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
public interface IOutRecordService  {

    //获取全部数据
    List<OutRecord> getAll();

    //  根据id获取地址
    OutRecord getById( Integer id);

    //  根据用户名 name名称获取
    List<OutRecord> getByName(String name);

    //  插入用户快递
    Integer insertOutRecord( OutRecord outRecord);

    //  根据名称删除数据
    Integer deleteByName( String name);

    //  更新用户数据
    OutRecord updateByName(String name,
                            OutRecord outRecord);

}
