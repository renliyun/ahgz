package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.OutRecord;
import com.vot.ahgz.mapper.OutRecordMapper;
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

    public static QueryWrapper<OutRecord> queryWrapper = null;

    @Override
    public List<OutRecord> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", 1000);
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

        return outRecordMapper.insert(outRecord);
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
