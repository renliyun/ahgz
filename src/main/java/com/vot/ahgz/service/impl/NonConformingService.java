package com.vot.ahgz.service.impl;

import com.vot.ahgz.entity.NonConforming;
import com.vot.ahgz.mapper.NonConformingMapper;
import com.vot.ahgz.service.INonConformingService;
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
public class NonConformingService  implements INonConformingService {

    @Override
    public List<NonConforming> getAll() {
        return null;
    }

    @Override
    public NonConforming getById(Integer id) {
        return null;
    }

    @Override
    public List<NonConforming> getByName(String name) {
        return null;
    }

    @Override
    public Integer insertNonConforming(NonConforming nonConforming) {
        return null;
    }

    @Override
    public Integer deleteByName(String name) {
        return null;
    }

    @Override
    public NonConforming updateByName(String name, NonConforming nonConforming) {
        return null;
    }
}
