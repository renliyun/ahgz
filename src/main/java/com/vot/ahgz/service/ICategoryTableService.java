package com.vot.ahgz.service;

import com.vot.ahgz.entity.AddressList;
import com.vot.ahgz.entity.CategoryTable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
public interface ICategoryTableService {

    //获取全部数据
    List<CategoryTable> getAll();


    //  插入用户快递
    Integer insertCategoryTable( CategoryTable categoryTable);


    //  根据名称删除数据
    Integer deleteById( Integer id);

    //  更新用户数据
    CategoryTable updateByName(CategoryTable categoryTable);

}
