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

    @Autowired
    private IAddressListService iAddressListService;

    @Override
    public List<AddressList> getAll() {
        QueryWrapper<AddressList> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id",1000);
        return addressListMapper.selectList(queryWrapper);
    }

    @Override
    public AddressList getOne(Integer id) {
        System.out.println("mp3获取的数据是：：：：：：：：：：：：" + addressListMapper.selectById(id));
        return addressListMapper.selectById(id);
    }


    @Override
    public AddressList getByName(String name) {
        QueryWrapper<AddressList> wrapper = new QueryWrapper<AddressList>();
        wrapper.eq("name", name);
        System.out.println(addressListMapper.selectOne(wrapper));
        return addressListMapper.selectOne(wrapper);
    }

    @Override
    public Integer insertAddressList(AddressList addressList) {
        System.out.println("SERVICE层得数据===========" + addressList);
        Integer result = addressListMapper.insert(addressList);
        return result;
    }

    @Override
    public Integer deleteByName(String name) {
        QueryWrapper<AddressList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        Integer result = addressListMapper.delete(queryWrapper);
        return result;
    }

    @Override
    public AddressList updateByName(AddressList addressList) {
        QueryWrapper<AddressList> queryWrapper = new QueryWrapper<>();
        addressListMapper.update(addressList, queryWrapper.eq("id", addressList.getId()));
        return addressListMapper.selectOne(queryWrapper);
    }
}
