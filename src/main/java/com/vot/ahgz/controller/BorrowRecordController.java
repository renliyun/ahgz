package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.BorrowRecord;
import com.vot.ahgz.service.IBorrowRecordService;
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
@RequestMapping("/borrowRecord")
public class BorrowRecordController {

    @Autowired
    private IBorrowRecordService iBorrowRecordService;

    @RequestMapping("/getAll")
    public CommonResult<List<BorrowRecord>> getAll() {
        System.out.println("进入controller层了！");
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iBorrowRecordService.getAll());
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }


    @RequestMapping("/getOneByName")
    public CommonResult<List<BorrowRecord>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iBorrowRecordService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    public CommonResult<Integer> insertAddressList(@ModelAttribute BorrowRecord borrowRecord) {
        return CommonResult.sucess(iBorrowRecordService.insertBorrowRecord(borrowRecord), "用户数据插入成功");
    }

    @PostMapping("/deleteByName")
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iBorrowRecordService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    public CommonResult<Integer> updateByName(@ModelAttribute BorrowRecord borrowRecord) {
        iBorrowRecordService.updateByName(borrowRecord);
        return CommonResult.sucess(iBorrowRecordService.updateByName(borrowRecord),"用户数据修改成功");
    }
}

