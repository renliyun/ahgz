package com.vot.ahgz.service.impl;

import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IStorageTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
@Service
public class StorageTableService  implements IStorageTableService {

    @Override
    public List<StorageTable> getAll() {
        return null;
    }

    @Override
    public StorageTable getById(Integer id) {
        return null;
    }

    @Override
    public List<StorageTable> getByName(String name) {
        return null;
    }

    @Override
    public Integer insertStorageTable(StorageTable storageTable) {
        return null;
    }

    @Override
    public Integer deleteByName(String name) {
        return null;
    }

    @Override
    public StorageTable updateByName(String name, StorageTable storageTable) {
        return null;
    }
}
