package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.NonConforming;
import com.vot.ahgz.mapper.NonConformingMapper;
import com.vot.ahgz.service.INonConformingService;
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
public class NonConformingService implements INonConformingService {

    @Autowired
    private NonConformingMapper nonConformingMapper;

    public static QueryWrapper<NonConforming> queryWrapper = null;

    @Override
    public List<NonConforming> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", 1000);
        return nonConformingMapper.selectList(queryWrapper);
    }

    @Override
    public NonConforming getById(Integer id) {
        return nonConformingMapper.selectById(id);
    }

    @Override
    public List<NonConforming> getByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return nonConformingMapper.selectList(queryWrapper);
    }

    @Override
    public Integer insertNonConforming(NonConforming nonConforming) {
        return nonConformingMapper.insert(nonConforming);
    }

    @Override
    public Integer deleteByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
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
