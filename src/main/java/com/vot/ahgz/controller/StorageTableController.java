package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.OutRecord;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.service.IStorageTableService;
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
@RequestMapping("/storageTable")
@Api("库存列表")
public class StorageTableController {

    @Autowired
    private IStorageTableService iStorageTableService;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有的库存信息")
    public CommonResult<List<StorageTable>> getAll() {
        System.out.println("进入controller层了！");
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iStorageTableService.getAll());
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }


    @GetMapping("/getOneByName")
    @ApiOperation(value = "获取name的库存信息")
    public CommonResult<List<StorageTable>> getByName(@RequestParam("name") String name) {
        return CommonResult.sucess(iStorageTableService.getByName(name), "获取用户" + name + "数据成功");
    }
    /*
    1、需要增加导出、导入excel表格
    2、需要增加根据类别、图号、材料等的查询方法
     */
    @PostMapping("/insertDate")
    @ApiOperation(value = "入库")
    @ApiIgnore()
    public CommonResult<Integer> insertAddressList(@ModelAttribute StorageTable storageTable) {
        return CommonResult.sucess(iStorageTableService.insertStorageTable(storageTable), "用户数据插入成功");
    }

    @PostMapping("/deleteByName")
    @ApiOperation(value = "删除name库存")
    @ApiIgnore()
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iStorageTableService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    @ApiOperation(value = "更新一条记录")
    @ApiIgnore()
    public CommonResult<Integer> updateByName(@ModelAttribute StorageTable storageTable) {
        iStorageTableService.updateByName(storageTable);
        return CommonResult.sucess(iStorageTableService.updateByName(storageTable),"用户数据修改成功");
    }
}

