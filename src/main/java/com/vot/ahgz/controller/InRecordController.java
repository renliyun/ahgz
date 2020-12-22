package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.DeliveryRecord;
import com.vot.ahgz.entity.InRecord;
import com.vot.ahgz.service.IInRecordService;
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
@RequestMapping("/inRecord")
public class InRecordController {

    @Autowired
    private IInRecordService iInRecordService;

    @RequestMapping("/getAll")
    public CommonResult<List<InRecord>> getAll() {
        System.out.println("进入controller层了！");
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iInRecordService.getAll());
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }


    @RequestMapping("/getOneByName")
    public CommonResult<List<InRecord>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iInRecordService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    public CommonResult<Integer> insertAddressList(@ModelAttribute InRecord inRecord) {
        return CommonResult.sucess(iInRecordService.insertInRecord(inRecord), "用户数据插入成功");
    }

    @PostMapping("/deleteByName")
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iInRecordService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    public CommonResult<Integer> updateByName(@ModelAttribute InRecord inRecord) {
        iInRecordService.updateByName(inRecord);
        return CommonResult.sucess(iInRecordService.updateByName(inRecord),"用户数据修改成功");
    }
}

