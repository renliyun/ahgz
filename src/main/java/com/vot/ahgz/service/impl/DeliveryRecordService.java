package com.vot.ahgz.service.impl;

import com.vot.ahgz.entity.DeliveryRecord;
import com.vot.ahgz.mapper.DeliveryRecordMapper;
import com.vot.ahgz.service.IDeliveryRecordService;
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
public class DeliveryRecordService implements IDeliveryRecordService {

    @Override
    public List<DeliveryRecord> getAll() {
        return null;
    }

    @Override
    public DeliveryRecord getById(Integer id) {
        return null;
    }

    @Override
    public List<DeliveryRecord> getByName(String name) {
        return null;
    }

    @Override
    public Integer insertDeliveryRecord(DeliveryRecord deliveryRecord) {
        return null;
    }

    @Override
    public Integer deleteByName(String name) {
        return null;
    }

    @Override
    public DeliveryRecord updateByName(String name, DeliveryRecord deliveryRecord) {
        return null;
    }
}
