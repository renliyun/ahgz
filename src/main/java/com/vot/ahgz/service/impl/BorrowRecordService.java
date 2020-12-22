package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.BorrowRecord;
import com.vot.ahgz.mapper.BorrowRecordMapper;
import com.vot.ahgz.service.IBorrowRecordService;
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
public class BorrowRecordService implements IBorrowRecordService {


    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Override
    public List<BorrowRecord> getAll() {
        // TODO
        QueryWrapper<BorrowRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", 1000);
        return borrowRecordMapper.selectList(queryWrapper);
    }

    @Override
    public List<BorrowRecord> getByName(String name) {
        QueryWrapper<BorrowRecord> queryWrapper = new QueryWrapper<>();
        return borrowRecordMapper.selectList(queryWrapper.eq("name", name));
    }

    @Override
    public Integer insertBorrowRecord(BorrowRecord borrowRecord) {
        return borrowRecordMapper.insert(borrowRecord);
    }

    @Override
    public Integer deleteByName(String name) {
        QueryWrapper<BorrowRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
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
