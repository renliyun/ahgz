package com.vot.ahgz.service;

import com.vot.ahgz.entity.InRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
public interface IInRecordService {

    //获取全部数据
    List<InRecord> getAll(InRecord inRecord);

    //  根据id获取地址
    InRecord getById(Integer id);

    //  根据用户名 name名称获取
    List<InRecord> getByName(String name);

    //  插入用户快递
    Integer insertInRecord(InRecord inRecord, HttpServletRequest request);

    //  根据名称删除数据
    Integer deleteByName(String name);

    //  根据名称删除数据
    Integer deleteById(Integer id);

    //  更新用户数据
    Integer updateByName(InRecord inRecord);

}
