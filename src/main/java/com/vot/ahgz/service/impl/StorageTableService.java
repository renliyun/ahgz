package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IStorageTableService;
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
public class StorageTableService implements IStorageTableService {

    private static final Logger logger=  LoggerFactory.getLogger(StorageTableService.class);

    @Autowired
    private StorageTableMapper storageTableMapper;

    public static QueryWrapper<StorageTable> queryWrapper = null;

    @Override
    public List<StorageTable> getAll(StorageTable storageTable) {
        queryWrapper = new QueryWrapper<>();

        if (null != storageTable){
            //将查询条件放入
          if ("" !=  storageTable.getPartName()){
              System.out.println("========================================"+storageTable.getPartName());
              queryWrapper.eq("part_name",storageTable.getPartName());
          }
          if ("" != storageTable.getFigureNumber()){
              queryWrapper.eq("figure_number",storageTable.getFigureNumber());
          }
          if ("" != storageTable.getSupplier()){
              queryWrapper.eq("supplier",storageTable.getSupplier());
          }
          if ("" != storageTable.getLocation()){
              queryWrapper.eq("location",storageTable.getLocation());
          }
          if ("" != storageTable.getCreatedName()){
              queryWrapper.eq("created_name",storageTable.getCreatedName());
          }
          if ("" != storageTable.getPartSpecification()){
              queryWrapper.eq("part_specification",storageTable.getPartSpecification());
          }
          if ("" != storageTable.getCategory()){
              queryWrapper.eq("category",storageTable.getCategory());
          }
        }else {
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
}
