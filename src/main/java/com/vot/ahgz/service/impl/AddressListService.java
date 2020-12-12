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
        return null;
    }

    @Override
    public AddressList getById(Integer id) {
        return null;
    }

    @Override
    public List<AddressList> getByName(String name) {
        return null;
    }

    @Override
    public Integer insertAddressList(AddressList addressList) {
        return null;
    }

    @Override
    public Integer deleteByName(String name) {
        return null;
    }

    @Override
    public AddressList updateByName(String name, AddressList addressList) {
        return null;
    }
}
