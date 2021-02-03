package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.OutRecord;
import com.vot.ahgz.entity.Page;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.service.IStorageTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;
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
@RequestMapping("/storageTable")
@Api("库存列表")
public class StorageController {

    @Autowired
    private IStorageTableService iStorageTableService;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有的库存信息")
    public ModelAndView getAll(@ModelAttribute StorageTable storageTable) {
        System.out.println("请求数据===================" + storageTable);
        ModelAndView modelAndView = new ModelAndView();
        List<StorageTable> storageTableList = null;
        Page page = new Page();

        if (null == storageTable.getMatnr()
                && StringUtils.isEmpty(storageTable.getPartName())
                && StringUtils.isEmpty(storageTable.getPartSpecification())
                && StringUtils.isEmpty(storageTable.getFigureNumber())
                && StringUtils.isEmpty(storageTable.getSupplier())
                && StringUtils.isEmpty(storageTable.getCategory())
                && StringUtils.isEmpty(storageTable.getLocation())
                && StringUtils.isEmpty(storageTable.getCreatedName())
        ) {
            storageTableList = iStorageTableService.getAll(storageTable);
            page.setPageData(storageTableList.subList(0, storageTableList.size() > 0 && storageTableList.size() <= 100 ? storageTableList.size() : 100));

        } else {
            storageTableList = iStorageTableService.getAll(storageTable);
            page.setPageData(storageTableList.subList(0, storageTableList.size() > 0 && storageTableList.size() <= 100 ? storageTableList.size() : 100));
        }
        modelAndView.addObject("page", page);
        modelAndView.addObject("storage", new StorageTable());

        System.out.println(page);
        modelAndView.setViewName("storage");
        return modelAndView;
    }


//    @GetMapping("/getOneByName")
//    @ApiOperation(value = "获取name的库存信息")
//    public CommonResult<List<StorageTable>> getByName(@RequestParam("name") String name) {
//        return CommonResult.sucess(iStorageTableService.getByName(name), "获取用户" + name + "数据成功");
//    }

    /*
    1、需要增加导出、导入excel表格
    2、需要增加根据类别、图号、材料等的查询方法
     */
//    @PostMapping("/insertDate")
//    @ApiOperation(value = "入库")
//    @ApiIgnore()
//    public CommonResult<Integer> insertAddressList(@ModelAttribute StorageTable storageTable) {
//        return CommonResult.sucess(iStorageTableService.insertStorageTable(storageTable), "用户数据插入成功");
//    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "删除name库存")
    @ApiIgnore()
    public CommonResult<Integer> deleteByName(@RequestParam("id") Integer id) {
        Integer result = iStorageTableService.deleteById(id);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PostMapping("/updateOne")
    @ApiOperation(value = "更新一条记录")
    public CommonResult<Integer> updateByName(@RequestBody StorageTable storageTable) {
        System.out.println(storageTable);
        iStorageTableService.updateOne(storageTable);
        return CommonResult.sucess(iStorageTableService.updateOne(storageTable), "本条数据修改成功！");
    }

    @GetMapping("/updateById")
    @ApiOperation(value = "更新一条记录")
    @ResponseBody
    public CommonResult updateById(Integer id) {
        // 不存在没有数据的
        StorageTable storageTable = iStorageTableService.updateById(id);
        return CommonResult.sucess(storageTable);
    }

//    @GetMapping("/update")
//    @ApiOperation(value = "更新一条记录")
//    public ModelAndView update() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("storageUpdate");
//        modelAndView.addObject("storageTable", new StorageTable());
//        return modelAndView;
//    }
}

