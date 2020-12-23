package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IStorageTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Autowired
    private StorageTableMapper storageTableMapper;

    public static QueryWrapper<StorageTable> queryWrapper = null;

    @Override
    public List<StorageTable> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", Integer.MAX_VALUE);
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
