package com.vot.ahgz.service.impl;

import com.vot.ahgz.entity.AddressList;
import com.vot.ahgz.mapper.AddressListMapper;
import com.vot.ahgz.service.IAddressListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public AddressList getById(Integer id) {
        return addressListMapper.getById(id);
    }
}
