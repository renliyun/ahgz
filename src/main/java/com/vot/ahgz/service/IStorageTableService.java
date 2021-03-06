package com.vot.ahgz.service;

import com.vot.ahgz.entity.StorageTable;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
public interface IStorageTableService  {


    //获取全部数据
    List<StorageTable> getAll(StorageTable storageTable);

    //  根据id获取地址
    StorageTable getById(Integer id);

    //  根据用户名 name名称获取
    List<StorageTable> getByName(String name);

    //  插入用户快递
    Integer insertStorageTable( StorageTable storageTable);

    //  根据名称删除数据
    Integer deleteByName( String name);

    //  根据名称删除数据
    Integer deleteById( Integer id, HttpServletRequest request);

    //  更新用户数据
    Integer updateOne(StorageTable storageTable ,HttpServletRequest request);

    //  更新用户数据
    StorageTable updateById(Integer id);


}
