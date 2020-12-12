package com.vot.ahgz.service.impl;

import com.vot.ahgz.entity.OutRecord;
import com.vot.ahgz.mapper.OutRecordMapper;
import com.vot.ahgz.service.IOutRecordService;
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
public class OutRecordService implements IOutRecordService {

    @Override
    public List<OutRecord> getAll() {
        return null;
    }

    @Override
    public OutRecord getById(Integer id) {
        return null;
    }

    @Override
    public List<OutRecord> getByName(String name) {
        return null;
    }

    @Override
    public Integer insertOutRecord(OutRecord outRecord) {
        return null;
    }

    @Override
    public Integer deleteByName(String name) {
        return null;
    }

    @Override
    public OutRecord updateByName(String name, OutRecord outRecord) {
        return null;
    }
}
