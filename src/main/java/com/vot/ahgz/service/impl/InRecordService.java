package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.InRecord;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.mapper.InRecordMapper;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IInRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
public class InRecordService implements IInRecordService {

    @Autowired
    private InRecordMapper inRecordMapper;

    @Autowired
    private StorageTableMapper storageTableMapper;

    public static QueryWrapper<InRecord> queryWrapper = null;

    @Override
    public List<InRecord> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", Integer.MAX_VALUE);
        return inRecordMapper.selectList(queryWrapper);
    }

    @Override
    public InRecord getById(Integer id) {
        return inRecordMapper.selectById(id);
    }

    @Override
    public List<InRecord> getByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return inRecordMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional // 增加事物
    public Integer insertInRecord(InRecord inRecord) {
        // todo 需要进行库存处理 然后插入入库记录内
        try {
            // 判断库存是否有原始物料记录
            QueryWrapper<StorageTable> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("part_name", inRecord.getPartName());
            queryWrapper1.eq("figure_number", inRecord.getFigureNumber());
            StorageTable storageTable = storageTableMapper.selectOne(queryWrapper1);
            if (null == storageTable) {
                //保存入库存  需要创建新的
                StorageTable storageTable1 = new StorageTable();
                storageTable1.setNumber(inRecord.getQuantity());
                storageTable1.setCategory(inRecord.getCategory());
                storageTable1.setCreatedName(inRecord.getCreatedName());
                storageTable1.setCreatedTime(new Date().toString());
                storageTable1.setFigureNumber(null == inRecord.getFigureNumber() ? null : inRecord.getFigureNumber());
                storageTable1.setLocation(inRecord.getLocation());
                storageTable1.setMark(null == inRecord.getMark() ? null : inRecord.getMark());
                storageTable1.setMaterial(null == inRecord.getMaterial() ? null : inRecord.getMaterial());
                storageTable1.setPartName(inRecord.getPartName());
                storageTable1.setPartSpecification(null == inRecord.getPartSpecification() ? null : inRecord.getPartSpecification());
                storageTable1.setSupplier(null == inRecord.getSupplier() ? null : inRecord.getSupplier());
                storageTable1.setUpdatedName(inRecord.getUpdatedName());
                storageTable1.setUpdateTime(new Date().toString());
                storageTableMapper.insert(storageTable1);
            } else {
                // 在原来的基础上增加库存
                storageTable.setNumber(storageTable.getNumber() + inRecord.getQuantity());
                storageTableMapper.updateById(storageTable);
            }
            return inRecordMapper.insert(inRecord);
        } catch (Exception e) {
            System.out.println("入库失败！");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer deleteByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return inRecordMapper.delete(queryWrapper);
    }

    @Override
    public Integer deleteById(Integer id) {
        return inRecordMapper.deleteById(id);
    }

    @Override
    public Integer updateByName(InRecord inRecord) {
        return inRecordMapper.updateById(inRecord);
    }
}
