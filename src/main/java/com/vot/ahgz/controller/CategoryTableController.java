package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.CategoryTable;
import com.vot.ahgz.entity.DeliveryRecord;
import com.vot.ahgz.service.ICategoryTableService;
import com.vot.ahgz.service.IDeliveryRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/categoryTable")
@Api(value = "类别表格")
public class CategoryTableController {

    @Autowired
    private ICategoryTableService iCategoryTableService;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取全部类别")
    public CommonResult<List<CategoryTable>> getAll() {
        System.out.println();
        return CommonResult.sucess(iCategoryTableService.getAll(), "获取类别列表成功！");
    }


    @GetMapping("/addCategory")
    @ApiOperation(value = "添加类别")
    public CommonResult<Integer> insertCategoryTable(CategoryTable categoryTable) {
        return CommonResult.sucess(iCategoryTableService.insertCategoryTable(categoryTable));
    }


    @GetMapping("/delectById")
    @ApiOperation(value = "删除根据id")
    public CommonResult<Integer> deleteById(Integer id) {
        return CommonResult.sucess(iCategoryTableService.deleteById(id));
    }

    @GetMapping("/updateByName")
    @ApiOperation(value = "更新类别")
    public CommonResult<CategoryTable> updateByName(CategoryTable categoryTable) {
        return CommonResult.sucess(iCategoryTableService.updateByName(categoryTable));
    }

}

