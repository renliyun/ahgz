package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.NonConforming;
import com.vot.ahgz.mapper.NonConformingMapper;
import com.vot.ahgz.service.INonConformingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class NonConformingService implements INonConformingService {

    private static final Logger logger=  LoggerFactory.getLogger(NonConformingService.class);

    @Autowired
    private NonConformingMapper nonConformingMapper;

    public static QueryWrapper<NonConforming> queryWrapper = null;

    @Override
    public List<NonConforming> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", Integer.MAX_VALUE);
        return nonConformingMapper.selectList(queryWrapper);
    }

    @Override
    public NonConforming getById(Integer id) {
        return nonConformingMapper.selectById(id);
    }

    @Override
    public List<NonConforming> getByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return nonConformingMapper.selectList(queryWrapper);
    }

    @Override
    public Integer insertNonConforming(NonConforming nonConforming) {
        // 分为插入数据和在原来的基础上增加
        try {
            queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("part_name", nonConforming.getPartName());
            queryWrapper.eq("figure_number", nonConforming.getFigureNumber());
            NonConforming nonConforming1 = nonConformingMapper.selectOne(queryWrapper);
            if (null == nonConforming1) {
                // 直接插入
                nonConformingMapper.insert(nonConforming);
            } else {
                //需要在原来的基础上更新
                nonConforming1.setQuantity(nonConforming1.getQuantity() + nonConforming.getQuantity());
                nonConformingMapper.updateById(nonConforming1);
            }
        } catch (Exception e) {
            System.out.println("插入不良品失效");
            e.printStackTrace();
        }
        return nonConformingMapper.insert(nonConforming);
    }

    @Override
    public Integer deleteByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return nonConformingMapper.delete(queryWrapper);
    }

    @Override
    public Integer deleteById(Integer id) {
        return nonConformingMapper.deleteById(id);
    }

    @Override
    public Integer updateByName(NonConforming nonConforming) {
        return nonConformingMapper.updateById(nonConforming);
    }
}
