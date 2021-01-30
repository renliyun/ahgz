package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.DeliveryRecord;
import com.vot.ahgz.entity.InRecord;
import com.vot.ahgz.entity.Page;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.service.IInRecordService;
import com.vot.ahgz.service.IStorageTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;
import springfox.documentation.annotations.ApiIgnore;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
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
@RequestMapping("/inRecord")
@Api("入库信息")
public class InController {

    @Autowired
    private IInRecordService iInRecordService;

    @Autowired
    private IStorageTableService iStorageTableService;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有的入库记录")
    public Page getAll(@ModelAttribute InRecord inRecord) {
        System.out.println("入库查询" + inRecord);

        ModelAndView modelAndView = new ModelAndView();
        List<InRecord> list = iInRecordService.getAll(inRecord);
        Page page = new Page();
        page.setPageData(list);
        modelAndView.addObject("page", page);
        //  查询库存的条件
        modelAndView.addObject("inRecord", new InRecord());
        System.out.println(page); // 入库查询的条件
        modelAndView.setViewName("inRecord");



        return page;
    }

    @GetMapping("/in")
    @ApiOperation(value = "请求空页面")
    public ModelAndView getIn(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inRecord");
        modelAndView.addObject("inRecord", new InRecord());
        // model.addAttribute();
        return modelAndView;
    }

    @GetMapping("/checkIn")    // 暂时不做
    @ApiOperation(value = "请求空页面")
    public CommonResult checkIn(Integer matnr, HttpServletResponse response) {

        InRecord inRecord = new InRecord();
        if (null == matnr) {
            try {
                response.sendRedirect("http://localhost:8080/inRecord/in");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 需要根据matnr查询数据
            StorageTable storageTable1 = new StorageTable();
            storageTable1.setMatnr(matnr);
            List<StorageTable> storageTable = iStorageTableService.getAll(storageTable1);
            if (storageTable.size() > 0) {
                StorageTable storageTable2 = storageTable.get(0);
                System.out.println(storageTable2);
                // 将数据转到InRecord
                inRecord.setMatnr(null != storageTable2.getMatnr() ? storageTable2.getMatnr() : null);
                inRecord.setPartName(!StringUtils.isEmpty(storageTable2.getPartName()) ? storageTable2.getPartName() : null);
                inRecord.setPartSpecification(!StringUtils.isEmpty(storageTable2.getPartSpecification()) ? storageTable2.getPartSpecification() : null);
                inRecord.setFigureNumber(!StringUtils.isEmpty(storageTable2.getFigureNumber()) ? storageTable2.getFigureNumber() : null);
                inRecord.setMaterial(!StringUtils.isEmpty(storageTable2.getMaterial()) ? storageTable2.getMaterial() : "");
                inRecord.setCategory(!StringUtils.isEmpty(storageTable2.getCategory()) ? storageTable2.getCategory() : "");
                inRecord.setLocation(!StringUtils.isEmpty(storageTable2.getLocation()) ? storageTable2.getLocation() : "");
                inRecord.setSupplier(!StringUtils.isEmpty(storageTable2.getSupplier()) ? storageTable2.getSupplier() : "");
                System.out.println("inRecord======================" + inRecord);
                return CommonResult.sucess(inRecord);
            }
        }
        return CommonResult.sucess(null);
    }

    @GetMapping("/getOneByName")
    @ApiOperation(value = "获取零件name的所有入库记录")
    @ApiIgnore("TRUE")
    public CommonResult<List<InRecord>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iInRecordService.getByName(name), "获取用户" + name + "数据成功");
    }

    @PostMapping("/insertDate")
    @ApiOperation(value = "插入一条入库记录")
    public ModelAndView insertInRecord(@ModelAttribute InRecord inRecord) {
        Integer result = iInRecordService.insertInRecord(inRecord);
        ModelAndView modelAndView = new ModelAndView();
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
    @ApiOperation(value = "删除零部件name的所有记录---不开放")
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iInRecordService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    @ApiOperation(value = "更新零部件的入库记录")
    public CommonResult<Integer> updateByName(@ModelAttribute InRecord inRecord) {
        iInRecordService.updateByName(inRecord);
        return CommonResult.sucess(iInRecordService.updateByName(inRecord), "用户数据修改成功");
    }
}

