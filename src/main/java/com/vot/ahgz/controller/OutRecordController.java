package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.NonConforming;
import com.vot.ahgz.entity.OutRecord;
import com.vot.ahgz.service.IOutRecordService;
import io.swagger.annotations.Api;
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
@RequestMapping("/outRecord")
@Api("出库记录")
public class OutRecordController {

    @Autowired
    private IOutRecordService iOutRecordService;

    @GetMapping("/getAll")
    public CommonResult<List<OutRecord>> getAll() {
        System.out.println("进入controller层了！");
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iOutRecordService.getAll());
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }


    @GetMapping("/getOneByName")
    public CommonResult<List<OutRecord>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iOutRecordService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    public CommonResult<Integer> insertAddressList(@ModelAttribute OutRecord outRecord) {
        return CommonResult.sucess(iOutRecordService.insertOutRecord(outRecord), "用户数据插入成功");
    }

    @PostMapping("/deleteByName")
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iOutRecordService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    public CommonResult<Integer> updateByName(@ModelAttribute OutRecord outRecord) {
        iOutRecordService.updateByName(outRecord);
        return CommonResult.sucess(iOutRecordService.updateByName(outRecord),"用户数据修改成功");
    }
}

