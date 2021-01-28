package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.DeliveryRecord;
import com.vot.ahgz.entity.OutRecord;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.mapper.DeliveryRecordMapper;
import com.vot.ahgz.mapper.OutRecordMapper;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IDeliveryRecordService;
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
public class DeliveryRecordService implements IDeliveryRecordService {

    public static QueryWrapper<DeliveryRecord> queryWrapper = null;

    private static final Logger logger=  LoggerFactory.getLogger(DeliveryRecordService.class);

    @Autowired
    private DeliveryRecordMapper deliveryRecordMapper;

    @Autowired
    private StorageTableMapper storageTableMapper;

    @Autowired
    private OutRecordMapper outRecordMapper;

    @Override
    public List<DeliveryRecord> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", Integer.MAX_VALUE);
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
    @Transactional // 增加事物
    public Integer insertDeliveryRecord(DeliveryRecord deliveryRecord) {
        // TODO 发货需要看库里是否有，然后先出库再进行发货
        try {
            QueryWrapper<StorageTable> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("part_name", deliveryRecord.getPartName());
            queryWrapper1.eq("figure_number", deliveryRecord.getFigureNumber());
            StorageTable storageTable = storageTableMapper.selectOne(queryWrapper1);
            if (storageTable.getNumber() > 0 && storageTable.getNumber() >= deliveryRecord.getNumber()) {
                //可以发货，库存减少1
                storageTable.setNumber(storageTable.getNumber() - deliveryRecord.getNumber());
                //更新库存
                storageTableMapper.updateById(storageTable);
                // 增加出库记录
                OutRecord outRecord = new OutRecord();
                outRecord.setCategory(null == deliveryRecord.getCategory() ? null : deliveryRecord.getCategory());
                outRecord.setMatnr(null == deliveryRecord.getMatnr() ? null : deliveryRecord.getMatnr());
                //应该是当前登陆用户  可以传递用户id过来
                outRecord.setCreatedName(null == deliveryRecord.getCreatedName() ? null : deliveryRecord.getCreatedName());
                outRecord.setCreatedTime(new Date(System.currentTimeMillis()));
                outRecord.setFigureNumber(null == deliveryRecord.getFigureNumber() ? null : deliveryRecord.getFigureNumber());
                outRecord.setMark(null == deliveryRecord.getMark() ? null : deliveryRecord.getMark());
                // 发货不需要写材料
                outRecord.setMaterial(null);
                outRecord.setNumber(deliveryRecord.getNumber());
                outRecord.setPartName(deliveryRecord.getPartName());
                outRecord.setPartSpecification(null == deliveryRecord.getPartSpecification() ? null : deliveryRecord.getPartSpecification());
                outRecord.setReceiveName(deliveryRecord.getBorrowName());
                outRecord.setReceiveTime(new Date(System.currentTimeMillis()));
                outRecord.setSupplier(deliveryRecord.getSupplier());
                // 应该是当前登陆用户  可以传递用户id过来或者从session中获取
                outRecord.setUpdatedName(deliveryRecord.getCreatedName());
                outRecord.setUpdatedTime(new Date(System.currentTimeMillis()));

                // 保存发货记录
                Integer result = outRecordMapper.insert(outRecord);
                if (result < 0) {
                    throw new Exception("保存出库记录失败！");
                }
                // 进行发货处理
                return deliveryRecordMapper.insert(deliveryRecord);
            }
            return 0;  //没有库存，或者库存不足不能发货
        } catch (Exception e) {
            System.out.println("发货时出库异常！");
            e.printStackTrace();
        }
        return null;
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
