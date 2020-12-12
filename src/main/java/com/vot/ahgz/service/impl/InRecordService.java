package com.vot.ahgz.service.impl;

import com.vot.ahgz.entity.InRecord;
import com.vot.ahgz.mapper.InRecordMapper;
import com.vot.ahgz.service.IInRecordService;
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
public class InRecordService implements IInRecordService {

    @Override
    public List<InRecord> getAll() {
        return null;
    }

    @Override
    public InRecord getById(Integer id) {
        return null;
    }

    @Override
    public List<InRecord> getByName(String name) {
        return null;
    }

    @Override
    public Integer insertInRecord(InRecord inRecord) {
        return null;
    }

    @Override
    public Integer deleteByName(String name) {
        return null;
    }

    @Override
    public InRecord updateByName(String name, InRecord inRecord) {
        return null;
    }
}
