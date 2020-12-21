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
        return null;
    }

    @Override
    public AddressList getOne(Integer id) {
        System.out.println("mp3获取的数据是：：：：：：：：：：：："+addressListMapper.selectById(id));
        return addressListMapper.selectById(id);
    }


    @Override
    public AddressList getByName(String name) {
         QueryWrapper<AddressList> wrapper = new QueryWrapper<AddressList>();
         wrapper.eq("name",name);
        System.out.println(addressListMapper.selectOne(wrapper));
        return addressListMapper.selectOne(wrapper);
    }

    @Override
    public Integer insertAddressList(AddressList addressList) {
        System.out.println("SERVICE层得数据===========" + addressList);
        return null;
    }

    @Override
    public Integer deleteByName(String name) {

        return null;
    }

    @Override
    public AddressList updateByName(AddressList addressList) {
        //  直接删除重新插入  应该没有得信息补齐
        addressListMapper.deleteById(addressList.getId());
        AddressList addressList1 = new AddressList();
        // System.out.println(addressList.getId());
        // System.out.println(addressList1);
        // 更新用户数据  根据用户得名称更新
        addressList1.setAddress(null == addressList.getAddress() ? null : addressList.getAddress());
        addressList1.setCreatedName(null == addressList.getCreatedName() ? null : addressList.getCreatedName());
        addressList1.setCreatedTime(null == addressList.getCreatedTime() ? null : addressList.getCreatedTime());
        addressList1.setName(null == addressList.getName() ? null : addressList.getName());
        addressList1.setTelephone(null == addressList.getTelephone() ? null : addressList.getTelephone());
        addressList1.setUpdatedName(null == addressList.getUpdatedName() ? null : addressList.getUpdatedName());
        addressList1.setMark(null == addressList.getMark() ? null : addressList.getMark());
        addressList1.setUpdateTime(null == addressList.getUpdateTime() ? null : addressList.getUpdateTime());
        // addressListMapper.insertAddressList(addressList1);
        return addressList1;
    }
}
