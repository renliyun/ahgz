package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IStorageTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

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
public class StorageTableService implements IStorageTableService {

    private static final Logger logger = LoggerFactory.getLogger(StorageTableService.class);

    @Autowired
    private StorageTableMapper storageTableMapper;

    public static QueryWrapper<StorageTable> queryWrapper = null;

    @Override
    public List<StorageTable> getAll(StorageTable storageTable) {
        queryWrapper = new QueryWrapper<>();
        System.out.println("请求数据===================" + storageTable);
        if (null != storageTable) {
            //将查询条件放入
            if (!StringUtils.isEmpty(storageTable.getPartName())) {
                System.out.println("========================================" + storageTable.getPartName());
                queryWrapper.eq("part_name", storageTable.getPartName());
            }
            if (null != storageTable.getMatnr()) {
                System.out.println("========================================" + storageTable.getPartName());
                queryWrapper.eq("matnr", storageTable.getMatnr());
            }
            if (!StringUtils.isEmpty(storageTable.getFigureNumber())) {
                queryWrapper.eq("figure_number", storageTable.getFigureNumber());
            }
            if (!StringUtils.isEmpty(storageTable.getSupplier())) {
                queryWrapper.eq("supplier", storageTable.getSupplier());
            }
            if (!StringUtils.isEmpty(storageTable.getLocation())) {
                queryWrapper.eq("location", storageTable.getLocation());
            }
            if (!StringUtils.isEmpty(storageTable.getCreatedName())) {
                queryWrapper.eq("created_name", storageTable.getCreatedName());
            }
            if (!StringUtils.isEmpty(storageTable.getPartSpecification())) {
                queryWrapper.eq("part_specification", storageTable.getPartSpecification());
            }
            if (!StringUtils.isEmpty(storageTable.getCategory())) {
                queryWrapper.eq("category", storageTable.getCategory());
            }
        } else {
            queryWrapper.le("id", Integer.MAX_VALUE);
        }
        return storageTableMapper.selectList(queryWrapper);
    }

    @Override
    public StorageTable getById(Integer id) {

        return storageTableMapper.selectById(id);
    }

    @Override
    public List<StorageTable> getByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return storageTableMapper.selectList(queryWrapper);
    }

    @Override
    public Integer insertStorageTable(StorageTable storageTable) {

        return storageTableMapper.insert(storageTable);
    }

    @Override
    public Integer deleteByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return storageTableMapper.delete(queryWrapper);
    }

    @Override
    public Integer deleteById(Integer id) {
        return storageTableMapper.deleteById(id);
    }

    @Override
    public Integer updateByName(StorageTable storageTable) {
        return storageTableMapper.updateById(storageTable);
    }

    @Override
    public StorageTable updateById(Integer id) {
        return storageTableMapper.selectById(id);
    }
}
