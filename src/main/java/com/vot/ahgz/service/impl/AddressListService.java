package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.vot.ahgz.entity.AddressList;
import com.vot.ahgz.mapper.AddressListMapper;
import com.vot.ahgz.service.IAddressListService;
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
public class AddressListService implements IAddressListService {

    @Autowired
    private AddressListMapper addressListMapper;

    public static QueryWrapper<AddressList> queryWrapper = null;

    @Override
    public List<AddressList> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", Integer.MAX_VALUE);
        return addressListMapper.selectList(queryWrapper);
    }

    @Override
    public AddressList getOne(Integer id) {
        return addressListMapper.selectById(id);
    }


    @Override
    public List<AddressList> getByName(String name) {
        queryWrapper = new QueryWrapper<AddressList>();
        queryWrapper.eq("name", name);
        return addressListMapper.selectList(queryWrapper);
    }

    @Override
    public Integer insertAddressList(AddressList addressList) {
        // 不进行判断
        Integer result = addressListMapper.insert(addressList);
        return result;
    }

    @Override
    public Integer deleteByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        Integer result = addressListMapper.delete(queryWrapper);
        return result;
    }

    @Override
    public Integer deleteById(Integer id) {
        return addressListMapper.deleteById(id);
    }

    @Override
    public AddressList updateByName(AddressList addressList) {
        queryWrapper = new QueryWrapper<>();
        addressListMapper.update(addressList, queryWrapper.eq("id", addressList.getId()));
        return addressListMapper.selectOne(queryWrapper);
    }
}
