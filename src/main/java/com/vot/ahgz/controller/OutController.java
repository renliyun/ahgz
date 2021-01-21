package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.InRecord;
import com.vot.ahgz.entity.NonConforming;
import com.vot.ahgz.entity.OutRecord;
import com.vot.ahgz.service.IOutRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

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
public class OutController {

    @Autowired
    private IOutRecordService iOutRecordService;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有的出库记录")
    public CommonResult<List<OutRecord>> getAll() {
        System.out.println("进入controller层了！");
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iOutRecordService.getAll());
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }


    @GetMapping("/out")
    @ApiOperation(value = "请求空页面")
    public ModelAndView getIn(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("outRecord");
        modelAndView.addObject("outRecord", new OutRecord());
        // model.addAttribute();
        return modelAndView;
    }

    @GetMapping("/getOneByName")
    @ApiOperation(value = "获取零部件name的所有出库记录")
    public CommonResult<List<OutRecord>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iOutRecordService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    @ApiOperation(value = "插入一条出库记录")
    public CommonResult<Integer> insertAddressList(@ModelAttribute OutRecord outRecord) {

        return CommonResult.sucess(iOutRecordService.insertOutRecord(outRecord), "用户数据插入成功");
    }

    @PostMapping("/deleteByName")
    @ApiOperation(value = "删除零部件name的出库记录")
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iOutRecordService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    @ApiOperation(value = "更新name的出库记录")
    public CommonResult<Integer> updateByName(@ModelAttribute OutRecord outRecord) {
        iOutRecordService.updateByName(outRecord);
        return CommonResult.sucess(iOutRecordService.updateByName(outRecord),"用户数据修改成功");
    }
}

