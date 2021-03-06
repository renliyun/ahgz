package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.entity.BorrowRecord;
import com.vot.ahgz.entity.InRecord;
import com.vot.ahgz.entity.Page;
import com.vot.ahgz.service.IBorrowRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ModelAndView getAll(@ModelAttribute BorrowRecord borrowRecord) {
        ModelAndView modelAndView = new ModelAndView();
        List<BorrowRecord> borrowRecordList = null;
        Page page = new Page();
        borrowRecordList = iBorrowRecordService.getAll(borrowRecord);

        if (borrowRecordList.size() > 0) {
            // 目的是控制入库记录得查询条数，防止前端缓存过多数数据
            page.setPageData(borrowRecordList.subList(0, borrowRecordList.size() > 0 && borrowRecordList.size() <= 50 ? borrowRecordList.size() : 50));
        } else {
            page.setPageData(null);
        }

        modelAndView.addObject("page", page);
        //  查询库存的条件
        modelAndView.addObject("borrowRecord", new BorrowRecord());
        modelAndView.setViewName("borrowRecordList");
        return modelAndView;

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
    public ModelAndView insertAddressList(@ModelAttribute BorrowRecord borrowRecord, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        Integer result = iBorrowRecordService.insertBorrowRecord(borrowRecord,request);
        String message = "";
        if (result == 0) {
            message = "库存不足，不可借用！";
            modelAndView.setViewName("error");
        } else if (result == 1){
            message = "借用成功！";
            modelAndView.setViewName("sucess");

        }else {
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

