package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.BorrowRecord;
import com.vot.ahgz.entity.DeliveryRecord;
import com.vot.ahgz.service.IDeliveryRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/deliveryRecord")
@Api(value = "发货表格")
public class DeliveryRecordController {

    @Autowired
    private IDeliveryRecordService iDeliveryRecordService;

    @GetMapping("/getAll")
    @ApiOperation(value = "所有的发货记录")
    public CommonResult<List<DeliveryRecord>> getAll() {
        System.out.println("进入controller层了！");
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iDeliveryRecordService.getAll());
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }


    @GetMapping("/getOneByName")
    @ApiOperation(value = "零部件名称的所有发货记录")
    public CommonResult<List<DeliveryRecord>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iDeliveryRecordService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    @ApiOperation(value = "添加一条发货记录")
    public CommonResult<Integer> insertAddressList(@ModelAttribute DeliveryRecord deliveryRecord) {
        return CommonResult.sucess(iDeliveryRecordService.insertDeliveryRecord(deliveryRecord), "用户数据插入成功");
    }

    @PostMapping("/deleteByName")
    @ApiOperation(value = "删除零部件的发货记录")
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iDeliveryRecordService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    @ApiOperation(value = "更新一条发货记录")
    public CommonResult<Integer> updateByName(@ModelAttribute DeliveryRecord deliveryRecord) {
        iDeliveryRecordService.updateByName(deliveryRecord);
        return CommonResult.sucess(iDeliveryRecordService.updateByName(deliveryRecord),"用户数据修改成功");
    }
}

