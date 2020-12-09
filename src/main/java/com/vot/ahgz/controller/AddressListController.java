package com.vot.ahgz.controller;


import com.vot.ahgz.entity.AddressList;
import com.vot.ahgz.service.IAddressListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/addressList")
public class AddressListController {

    @Autowired
    private IAddressListService iAddressListService;
    @RequestMapping("/add")
    public String getName(){
        return "addressList";
    }

    @RequestMapping("/getOne")
    public AddressList getOne(@RequestParam("id") Integer id){

        AddressList addressList = new AddressList();
        addressList.setAddress("北京321国道");
        addressList.setName("这是测试数据！");
        return  null != iAddressListService.getById(id)? iAddressListService.getById(id):addressList;
    }
}

