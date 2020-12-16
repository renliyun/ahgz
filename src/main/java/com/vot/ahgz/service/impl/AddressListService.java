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
 *  服务实现类
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
@Service
public class AddressListService  implements IAddressListService {

    @Autowired
    private AddressListMapper addressListMapper;

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
        System.out.println("SERVICE层得数据==========="+addressList);
        return addressListMapper.insertAddressList(addressList);
    }

    @Override
    public Integer deleteByName(String name) {

        return addressListMapper.deleteByName(name);
    }

    @Override
    public AddressList updateByName(String name, AddressList addressList) {
        return addressListMapper.updateByName(name,addressList);
    }
}
