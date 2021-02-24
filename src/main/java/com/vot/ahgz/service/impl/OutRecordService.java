package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.OutRecord;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.entity.UserTable;
import com.vot.ahgz.mapper.OutRecordMapper;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IOutRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
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
public class OutRecordService implements IOutRecordService {

    private static final Logger logger=  LoggerFactory.getLogger(OutRecordService.class);

    @Autowired
    private OutRecordMapper outRecordMapper;

    @Autowired
    private StorageTableMapper storageTableMapper;

    public static QueryWrapper<OutRecord> queryWrapper = null;

    @Override
    public List<OutRecord> getAll(OutRecord outRecord) {
        queryWrapper = new QueryWrapper<>();
        if (null != outRecord) {
            //将查询条件放入
            if (!StringUtils.isEmpty(outRecord.getPartName())) {
                System.out.println("========================================" + outRecord.getPartName());
                queryWrapper.like("part_name", outRecord.getPartName());
            }
            if (null != outRecord.getMatnr()) {
                System.out.println("========================================" + outRecord.getPartName());
                queryWrapper.eq("matnr", outRecord.getMatnr());
            }
            if (!StringUtils.isEmpty(outRecord.getFigureNumber())) {
                queryWrapper.like("figure_number", outRecord.getFigureNumber());
            }
            if (!StringUtils.isEmpty(outRecord.getSupplier())) {
                queryWrapper.like("supplier", outRecord.getSupplier());
            }
            if (!StringUtils.isEmpty(outRecord.getCreatedName())) {
                queryWrapper.like("created_name", outRecord.getCreatedName());
            }
            if (!StringUtils.isEmpty(outRecord.getPartSpecification())) {
                queryWrapper.like("part_specification", outRecord.getPartSpecification());
            }
            if (!StringUtils.isEmpty(outRecord.getCategory())) {
                queryWrapper.like("category", outRecord.getCategory());
            }
        } else {
            queryWrapper.le("id", Integer.MAX_VALUE);
        }
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
    public Integer insertOutRecord(OutRecord outRecord , HttpServletRequest request) {
        QueryWrapper<StorageTable> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("matnr", outRecord.getMatnr());
        StorageTable storageTable = storageTableMapper.selectOne(queryWrapper);
        if (null == storageTable || storageTable.getNumber() < outRecord.getNumber()) {
            logger.info("库存不足！无法出库");
            return 0;
        } else {
            UserTable userTable = (UserTable) request.getSession().getAttribute("user");
            // 减库存 出库
            storageTable.setNumber(storageTable.getNumber() - outRecord.getNumber());
            storageTable.setUpdatedName(outRecord.getCreatedName());
            storageTable.setUpdatedTime(new Date(System.currentTimeMillis()));
            storageTableMapper.updateById(storageTable);
            // 插入出库记录
            logger.info("出库成功，物料号为："+outRecord.getMatnr()+"得物料出库："+outRecord.getNumber()+"个,出库人"+userTable.getUsername());
            outRecord.setCreatedName(userTable.getUsername());
            outRecord.setCreatedTime(new Date(System.currentTimeMillis()));
            return outRecordMapper.insert(outRecord);
        }
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
