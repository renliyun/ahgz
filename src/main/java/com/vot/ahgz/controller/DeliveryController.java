package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.entity.DeliveryRecord;
import com.vot.ahgz.entity.Page;
import com.vot.ahgz.service.IDeliveryRecordService;
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
@RequestMapping("/deliveryRecord")
@Api(value = "发货表格")
public class DeliveryController {

    @Autowired
    private IDeliveryRecordService iDeliveryRecordService;

    @GetMapping("/getAll")
    @ApiOperation(value = "所有的发货记录")
    public Page getAll(@ModelAttribute DeliveryRecord deliveryRecord) {
        System.out.println("请求数据：" + deliveryRecord);
        List<DeliveryRecord> list = iDeliveryRecordService.getAll(deliveryRecord);
        Page page = new Page();
        return page;
    }


    @GetMapping("/delivery")
    @ApiOperation(value = "请求空页面")
    public ModelAndView getIn(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("delivery");
        modelAndView.addObject("deliveryRecord", new DeliveryRecord());
        return modelAndView;
    }


    @GetMapping("/getOneByName")
    @ApiOperation(value = "零部件名称的所有发货记录")
    public CommonResult<List<DeliveryRecord>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iDeliveryRecordService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    @ApiOperation(value = "添加一条发货记录  返回值：1表示发货成功；0表示发货失败")
    public ModelAndView insertAddressList(@ModelAttribute DeliveryRecord deliveryRecord , HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Integer result = iDeliveryRecordService.insertDeliveryRecord(deliveryRecord , request);
        String message = "";
        if (result == 0) {
            modelAndView.setViewName("error");
            message = "库存不足！";
        } else if (result == 1) {
            message = "发货成功！";
            modelAndView.setViewName("sucess");

        } else {
            modelAndView.setViewName("error");
            message = "发生未知异常，请检出数据！";
        }
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping("/deleteByName")
    @ApiOperation(value = "删除零部件的发货记录 --不允许")
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iDeliveryRecordService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    @ApiOperation(value = "更新一条发货记录")
    public CommonResult<Integer> updateByName(@ModelAttribute DeliveryRecord deliveryRecord) {
        iDeliveryRecordService.updateByName(deliveryRecord);
        return CommonResult.sucess(iDeliveryRecordService.updateByName(deliveryRecord), "用户数据修改成功");
    }
}

