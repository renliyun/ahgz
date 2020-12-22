package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.InRecord;
import com.vot.ahgz.entity.NonConforming;
import com.vot.ahgz.service.INonConformingService;
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
@RequestMapping("/nonConforming")
@Api("关于不良品的信息")
public class NonConformingController {

    @Autowired
    private INonConformingService iNonConformingService;

    @GetMapping("/getAll")
    @ApiOperation(value = "不良品的所有记录")
    public CommonResult<List<NonConforming>> getAll() {
        System.out.println("进入controller层了！");
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iNonConformingService.getAll());
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }


    @GetMapping("/getOneByName")
    @ApiOperation(value = "获取零部件name的所有不良品记录")
    public CommonResult<List<NonConforming>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iNonConformingService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    @ApiOperation(value = "插入不良品记录")
    public CommonResult<Integer> insertAddressList(@ModelAttribute NonConforming nonConforming) {
        return CommonResult.sucess(iNonConformingService.insertNonConforming(nonConforming), "用户数据插入成功");
    }

    @PostMapping("/deleteByName")
    @ApiOperation(value = "删除name的所有不良品记录")
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iNonConformingService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    @ApiOperation(value = "更新不良品记录")
    public CommonResult<Integer> updateByName(@ModelAttribute NonConforming nonConforming) {
        iNonConformingService.updateByName(nonConforming);
        return CommonResult.sucess(iNonConformingService.updateByName(nonConforming),"用户数据修改成功");
    }

}

