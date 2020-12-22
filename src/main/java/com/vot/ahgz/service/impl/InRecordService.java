package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.InRecord;
import com.vot.ahgz.mapper.InRecordMapper;
import com.vot.ahgz.service.IInRecordService;
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
public class InRecordService implements IInRecordService {

    @Autowired
    private InRecordMapper inRecordMapper;

    public static QueryWrapper<InRecord> queryWrapper = null;

    @Override
    public List<InRecord> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", 1000);
        return inRecordMapper.selectList(queryWrapper);
    }

    @Override
    public InRecord getById(Integer id) {
        return inRecordMapper.selectById(id);
    }

    @Override
    public List<InRecord> getByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return inRecordMapper.selectList(queryWrapper);
    }

    @Override
    public Integer insertInRecord(InRecord inRecord) {
        return inRecordMapper.insert(inRecord);
    }

    @Override
    public Integer deleteByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
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
