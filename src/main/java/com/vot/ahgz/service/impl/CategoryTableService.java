package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.CategoryTable;
import com.vot.ahgz.mapper.CategoryTableMapper;
import com.vot.ahgz.service.ICategoryTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger=  LoggerFactory.getLogger(CategoryTableService.class);

    @Autowired
    private CategoryTableMapper categoryTableMapper;

    public static QueryWrapper<CategoryTable> queryWrapper = null;

    @Override
    public List<CategoryTable> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", Integer.MAX_VALUE);
        return categoryTableMapper.selectList(queryWrapper);
    }


    @Override
    public Integer insertCategoryTable(CategoryTable categoryTable) {
        // todu不允许随意插入 需要判重
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", categoryTable.getName());
        CategoryTable categoryTable1 = categoryTableMapper.selectOne(queryWrapper);
        // 如果重名就不能够再重复添加 不重名就可以添加
        return categoryTable1 != null ? 0 : categoryTableMapper.insert(categoryTable);
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
