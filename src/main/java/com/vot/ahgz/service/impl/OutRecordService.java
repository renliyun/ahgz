package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.OutRecord;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.mapper.OutRecordMapper;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IOutRecordService;
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
public class OutRecordService implements IOutRecordService {

    @Autowired
    private OutRecordMapper outRecordMapper;

    @Autowired
    private StorageTableMapper storageTableMapper;

    public static QueryWrapper<OutRecord> queryWrapper = null;

    @Override
    public List<OutRecord> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", Integer.MAX_VALUE);
        return outRecordMapper.selectList(queryWrapper);
    }

    @Override
    public OutRecord getById(Integer id) {

        return outRecordMapper.selectById(id);
    }

    @Override
    public List<OutRecord> getByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return outRecordMapper.selectList(queryWrapper);
    }

    @Override
    public Integer insertOutRecord(OutRecord outRecord) {
        // TODO 需要处理库存 库里有才可以出库
        QueryWrapper<StorageTable> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", outRecord.getPartName());
        queryWrapper.eq("figure_number", outRecord.getFigureNumber());
        StorageTable storageTable = storageTableMapper.selectOne(queryWrapper);
        if (null == storageTable || storageTable.getNumber() < outRecord.getNumber()) {
            return 0;
        } else {
            // 减库存 出库
            storageTable.setNumber(storageTable.getNumber() - outRecord.getNumber());
            storageTableMapper.updateById(storageTable);
            // 插入出库记录
            return outRecordMapper.insert(outRecord);
        }
    }

    @Override
    public Integer deleteByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return outRecordMapper.delete(queryWrapper);
    }

    @Override
    public Integer deleteById(Integer id) {
        return outRecordMapper.deleteById(id);
    }

    @Override
    public Integer updateByName(OutRecord outRecord) {

        return outRecordMapper.updateById(outRecord);
    }
}
