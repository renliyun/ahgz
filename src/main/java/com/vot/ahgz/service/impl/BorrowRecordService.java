package com.vot.ahgz.service.impl;

import com.vot.ahgz.entity.BorrowRecord;
import com.vot.ahgz.mapper.BorrowRecordMapper;
import com.vot.ahgz.service.IBorrowRecordService;
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
public class BorrowRecordService  implements IBorrowRecordService {

    @Override
    public List<BorrowRecord> getAll() {
        return null;
    }

    @Override
    public List<BorrowRecord> getByName(String name) {
        return null;
    }

    @Override
    public Integer insertBorrowRecord(BorrowRecord borrowRecord) {
        return null;
    }

    @Override
    public Integer deleteByName(String name) {
        return null;
    }

    @Override
    public BorrowRecord updateByName(String name, BorrowRecord borrowRecord) {
        return null;
    }
}
