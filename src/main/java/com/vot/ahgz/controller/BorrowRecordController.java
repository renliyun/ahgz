package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.BorrowRecord;
import com.vot.ahgz.service.IBorrowRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import springfox.documentation.annotations.ApiIgnore;

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
@RequestMapping("/borrowRecord")
@Api("借用信息表api")
public class BorrowRecordController {

    @Autowired
    private IBorrowRecordService iBorrowRecordService;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有的借用记录")
    public CommonResult<List<BorrowRecord>> getAll() {
        System.out.println("进入controller层了！");
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iBorrowRecordService.getAll());
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }


    @GetMapping("/getOneByName")
    @ApiOperation(value = "获取name的所有的借用记录")
    public CommonResult<List<BorrowRecord>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iBorrowRecordService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    @ApiOperation(value = "插入一条借用信息")
    @ApiIgnore()
    public CommonResult<Integer> insertAddressList(@ModelAttribute BorrowRecord borrowRecord) {
        return CommonResult.sucess(iBorrowRecordService.insertBorrowRecord(borrowRecord), "用户数据插入成功");
    }

    @PostMapping("/deleteByName")
    @ApiOperation(value = "删除name的所有借用记录")
    @ApiIgnore()
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iBorrowRecordService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    @ApiOperation(value = "更新一条借用记录")
    public CommonResult<Integer> updateByName(@ModelAttribute BorrowRecord borrowRecord) {
        iBorrowRecordService.updateByName(borrowRecord);
        return CommonResult.sucess(iBorrowRecordService.updateByName(borrowRecord),"用户数据修改成功");
    }
}

