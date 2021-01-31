package com.vot.ahgz.controller;


import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.service.IStorageTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/export")
@Api("工具类，导出数据")
public class Export {


    @Autowired
    private IStorageTableService iStorageTableService;


    // 库存导出
    @GetMapping("storage")
    @ApiOperation(value = "库存数据导出")
    public void exportStorage(@ModelAttribute StorageTable storageTable){

    }


}
