package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.AddressList;
import com.vot.ahgz.service.IAddressListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 前端控制器
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

    @RequestMapping("/getAll")
    public CommonResult<List<AddressList>> getAll() {
        System.out.println("进入controller层了！");
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iAddressListService.getAll());
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }

    @RequestMapping("/getOne")
    public CommonResult<AddressList> getOne(@RequestParam("id") Integer id) {
        System.out.println("进入controller层了！");
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iAddressListService.getOne(id));
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }

    @RequestMapping("/getOneByName")
    public CommonResult<List<AddressList>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iAddressListService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    public CommonResult<Integer> insertAddressList(@ModelAttribute AddressList addressList) {
        return CommonResult.sucess(iAddressListService.insertAddressList(addressList), "用户数据插入成功");
    }

    @PostMapping("/deleteByName")
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iAddressListService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    public CommonResult<AddressList> updateByName(@ModelAttribute AddressList addressList) {
        iAddressListService.updateByName(addressList);
        return CommonResult.sucess(iAddressListService.updateByName(addressList),"用户数据修改成功");
    }
}

