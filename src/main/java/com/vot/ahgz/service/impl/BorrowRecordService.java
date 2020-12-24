package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.BorrowRecord;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.mapper.BorrowRecordMapper;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IBorrowRecordService;
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
public class BorrowRecordService implements IBorrowRecordService {


    private static final Logger logger=  LoggerFactory.getLogger(BorrowRecordService.class);

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Autowired
    private StorageTableMapper storageTableMapper;

    @Override
    public List<BorrowRecord> getAll() {
        // TODO
        QueryWrapper<BorrowRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", Integer.MAX_VALUE);
        return borrowRecordMapper.selectList(queryWrapper);
    }

    @Override
    public List<BorrowRecord> getByName(String name) {
        QueryWrapper<BorrowRecord> queryWrapper = new QueryWrapper<>();
        return borrowRecordMapper.selectList(queryWrapper.eq("part_name", name));
    }

    @Override
    public Integer insertBorrowRecord(BorrowRecord borrowRecord) {
        // TODO 是否有库存可以借用  涉及出库
        try {
            QueryWrapper<StorageTable> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("part_name", borrowRecord.getPartName());
            queryWrapper.eq("figure_number", borrowRecord.getFigureNumber());
            StorageTable storageTable = storageTableMapper.selectOne(queryWrapper);
            if (null == storageTable || storageTable.getNumber() < borrowRecord.getNumber()) {
                return 0; //不可借
            } else {
                // 更新库存
                storageTable.setNumber(storageTable.getNumber() - borrowRecord.getNumber());
                storageTableMapper.updateById(storageTable);
                return borrowRecordMapper.insert(borrowRecord);
            }
        } catch (Exception e) {
            System.out.println("借用错误");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteByName(String name) {
        QueryWrapper<BorrowRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return borrowRecordMapper.delete(queryWrapper);
    }

    @Override
    public Integer deleteById(Integer id) {
        return borrowRecordMapper.deleteById(id);
    }

    @Override
    public Integer updateByName(BorrowRecord borrowRecord) {
        return borrowRecordMapper.updateById(borrowRecord);
    }
}
