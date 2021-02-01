package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.BorrowRecord;
import com.vot.ahgz.entity.OutRecord;
import com.vot.ahgz.entity.Page;
import com.vot.ahgz.service.IBorrowRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

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
@RequestMapping("/borrowRecord")
@Api("借用信息表api")
public class BorrowController {

    @Autowired
    private IBorrowRecordService iBorrowRecordService;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有的借用记录")
    public Page getAll(@ModelAttribute BorrowRecord borrowRecord) {
        System.out.println("请求参数：" + borrowRecord);
        List<BorrowRecord> borrowRecords = iBorrowRecordService.getAll(borrowRecord);
        Page page = new Page();
        return page;
    }

    @GetMapping("/borrow")
    @ApiOperation(value = "请求空页面")
    public ModelAndView getIn(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("borrow");
        modelAndView.addObject("borrowRecord", new BorrowRecord());
        return modelAndView;
    }


    @GetMapping("/getOneByName")
    @ApiOperation(value = "获取name的所有的借用记录")
    public CommonResult<List<BorrowRecord>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iBorrowRecordService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    @ApiOperation(value = "插入一条借用信息")
    public ModelAndView insertAddressList(@ModelAttribute BorrowRecord borrowRecord) {
        ModelAndView modelAndView = new ModelAndView();
        Integer result = iBorrowRecordService.insertBorrowRecord(borrowRecord);
        String message = "";
        if (result > 0) {
            message = "数据插入成功！";
            modelAndView.setViewName("sucess");
        } else {
            modelAndView.setViewName("error");
            message = "发生未知异常，请检出数据！";
        }
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping("/deleteByName")
    @ApiOperation(value = "删除name的所有借用记录")
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iBorrowRecordService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    @ApiOperation(value = "更新一条借用记录")
    public CommonResult<Integer> updateByName(@ModelAttribute BorrowRecord borrowRecord) {
        iBorrowRecordService.updateByName(borrowRecord);
        return CommonResult.sucess(iBorrowRecordService.updateByName(borrowRecord), "用户数据修改成功");
    }
}

