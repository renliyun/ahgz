package com.vot.ahgz.service.impl;

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
        return addressListMapper.getAll();
    }


    @Override
    public List<AddressList> getByName(String name) {
        return addressListMapper.getByName(name);
    }

    @Override
    public Integer insertAddressList(AddressList addressList) {
        System.out.println("SERVICE层得数据===========" + addressList);
        return addressListMapper.insertAddressList(addressList);
    }

    @Override
    public Integer deleteByName(String name) {

        return addressListMapper.deleteByName(name);
    }

    @Override
    public AddressList updateByName(AddressList addressList) {

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
        addressListMapper.insertAddressList(addressList1);
        return addressList1;
    }
}
