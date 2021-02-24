package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.entity.OutRecord;
import com.vot.ahgz.entity.Page;
import com.vot.ahgz.service.IOutRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/outRecord")
@Api("出库记录")
public class OutController {

    @Autowired
    private IOutRecordService iOutRecordService;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有的出库记录")
    public ModelAndView getAll(@ModelAttribute OutRecord outRecord) {
        List<OutRecord> outRecordList = iOutRecordService.getAll(outRecord);
        ModelAndView modelAndView = new ModelAndView();
        Page page = new Page();
        if (outRecordList.size() > 0) {
            // 目的是控制入库记录得查询条数，防止前端缓存过多数数据
            page.setPageData(outRecordList.subList(0, outRecordList.size() > 0 && outRecordList.size() <= 50 ? outRecordList.size() : 50));
        } else {
            page.setPageData(null);
        }
        modelAndView.addObject("page", page);
        //  查询库存的条件
        modelAndView.addObject("outRecord", new OutRecord());
        System.out.println(page); // 入库查询的条件
        modelAndView.setViewName("outRecordList");
        return modelAndView;
    }


    @GetMapping("/out")
    @ApiOperation(value = "请求空页面")
    public ModelAndView getIn(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("outRecord");
        modelAndView.addObject("outRecord", new OutRecord());
        return modelAndView;
    }

    @GetMapping("/getOneByName")
    @ApiOperation(value = "获取零部件name的所有出库记录")
    public CommonResult<List<OutRecord>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iOutRecordService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    @ApiOperation(value = "插入一条出库记录")
    public ModelAndView insertAddressList(@ModelAttribute OutRecord outRecord , HttpServletRequest request) {

        Integer result = iOutRecordService.insertOutRecord(outRecord,request);
        ModelAndView modelAndView = new ModelAndView();
        String message = "";
        if (result == 0) {
            message = "库存不足，无法出库！";
            modelAndView.setViewName("error");
        } else if (result == 1){
            modelAndView.setViewName("sucess");
            message = "出库成功！";
        }else {
            modelAndView.setViewName("error");
            message = "发生未知异常，请检查！";
        }
        modelAndView.addObject("message", message);
        return modelAndView;
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
        return CommonResult.sucess(iOutRecordService.updateByName(outRecord), "用户数据修改成功");
    }
}

