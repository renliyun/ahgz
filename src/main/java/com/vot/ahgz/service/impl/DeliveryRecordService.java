package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.DeliveryRecord;
import com.vot.ahgz.mapper.DeliveryRecordMapper;
import com.vot.ahgz.service.IDeliveryRecordService;
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
public class DeliveryRecordService implements IDeliveryRecordService {

    public static QueryWrapper<DeliveryRecord> queryWrapper = null;

    @Autowired
    private DeliveryRecordMapper deliveryRecordMapper;

    @Override
    public List<DeliveryRecord> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", 1000);
        return deliveryRecordMapper.selectList(queryWrapper);
    }

    @Override
    public DeliveryRecord getById(Integer id) {
        return getById(id);
    }

    @Override
    public List<DeliveryRecord> getByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return deliveryRecordMapper.selectList(queryWrapper);
    }

    @Override
    public Integer insertDeliveryRecord(DeliveryRecord deliveryRecord) {
        return deliveryRecordMapper.insert(deliveryRecord);
    }

    @Override
    public Integer deleteByName(String name) {
        //  根据name删除不符合逻辑
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return deliveryRecordMapper.delete(queryWrapper);
    }

    @Override
    public Integer deleteById(Integer id) {
        //  根据id删除符合逻辑
        return deliveryRecordMapper.deleteById(id);
    }

    @Override
    public Integer updateByName(DeliveryRecord deliveryRecord) {
        return deliveryRecordMapper.updateById(deliveryRecord);
    }
}
