package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.InRecord;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.mapper.InRecordMapper;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IInRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
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

    private static final Logger logger=  LoggerFactory.getLogger(InRecordService.class);

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
            //需要确认数据的唯一性 图号+零部件名称是唯一还是图号是唯一
//            queryWrapper1.eq("part_name", inRecord.getPartName());
            // 物料号作为唯一
            queryWrapper1.eq("matnr", inRecord.getMatnr());
            StorageTable storageTable = storageTableMapper.selectOne(queryWrapper1);
            if (null == storageTable) {
                //保存入库存  需要创建新的
                StorageTable storageTable1 = new StorageTable();
                storageTable1.setNumber(inRecord.getQuantity());
                storageTable1.setMatnr(inRecord.getMatnr());
                storageTable1.setCategory(inRecord.getCategory());
                storageTable1.setCreatedName(inRecord.getCreatedName());
                storageTable1.setCreatedTime(new Date(System.currentTimeMillis()));
                storageTable1.setFigureNumber(null == inRecord.getFigureNumber() ? null : inRecord.getFigureNumber());
                storageTable1.setLocation(inRecord.getLocation());
                storageTable1.setMark(null == inRecord.getMark() ? null : inRecord.getMark());
                storageTable1.setMaterial(null == inRecord.getMaterial() ? null : inRecord.getMaterial());
                storageTable1.setPartName(inRecord.getPartName());
                storageTable1.setPartSpecification(null == inRecord.getPartSpecification() ? null : inRecord.getPartSpecification());
                storageTable1.setSupplier(null == inRecord.getSupplier() ? null : inRecord.getSupplier());
                storageTable1.setUpdatedName(inRecord.getUpdatedName());
                storageTable1.setUpdatedTime(new Date(System.currentTimeMillis()));
                storageTable1.setCreatedTime(new Date(System.currentTimeMillis()));
                storageTableMapper.insert(storageTable1);
                logger.info("保存入库成功！",storageTable1);
            } else {
                // 在原来的基础上增加库存
                storageTable.setNumber(storageTable.getNumber() + inRecord.getQuantity());
                storageTable.setUpdatedTime(new Date(System.currentTimeMillis()));
                storageTableMapper.updateById(storageTable);
                logger.info("更新库存成功",storageTable);
            }
            inRecord.setUpdatedTime(new Date(System.currentTimeMillis()).toString());
            return inRecordMapper.insert(inRecord);
        } catch (Exception e) {
            logger.error("入库存在位置异常！");
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
