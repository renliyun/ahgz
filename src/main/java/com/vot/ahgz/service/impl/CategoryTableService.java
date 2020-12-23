package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.AddressList;
import com.vot.ahgz.entity.CategoryTable;
import com.vot.ahgz.mapper.AddressListMapper;
import com.vot.ahgz.mapper.CategoryTableMapper;
import com.vot.ahgz.service.IAddressListService;
import com.vot.ahgz.service.ICategoryTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
@Service
public class CategoryTableService implements ICategoryTableService {

    @Autowired
    private CategoryTableMapper categoryTableMapper;

    public static QueryWrapper<CategoryTable> queryWrapper = null;

    @Override
    public List<CategoryTable> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", 1000);
        return categoryTableMapper.selectList(queryWrapper);
    }




    @Override
    public Integer insertCategoryTable(CategoryTable categoryTable) {
        // todu不允许随意插入 需要判重
        Integer result = categoryTableMapper.insert(categoryTable);
        return result;
    }


    @Override
    public Integer deleteById(Integer id) {
        return categoryTableMapper.deleteById(id);
    }

    @Override
    public CategoryTable updateByName(CategoryTable categoryTable) {
        queryWrapper = new QueryWrapper<>();
        categoryTableMapper.update(categoryTable, queryWrapper.eq("id", categoryTable.getId()));
        return categoryTableMapper.selectOne(queryWrapper);
    }
}
