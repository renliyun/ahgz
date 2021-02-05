package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.entity.Page;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.service.IStorageTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

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
@RequestMapping("/storageTable")
@Api("库存列表")
public class StorageController {

    @Autowired
    private IStorageTableService iStorageTableService;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有的库存信息")
    public ModelAndView getAll(@ModelAttribute StorageTable storageTable) {
        ModelAndView modelAndView = new ModelAndView();
        List<StorageTable> storageTableList = null;
        Page page = new Page();
        storageTableList = iStorageTableService.getAll(storageTable);
        if (storageTableList.size() > 0) {
            page.setPageData(storageTableList.subList(0, storageTableList.size() > 0 && storageTableList.size() <= 50 ? storageTableList.size() : 50));
        } else {
            page.setPageData(null);
        }
        modelAndView.addObject("page", page);
        modelAndView.addObject("storage", new StorageTable());
        modelAndView.setViewName("storage");
        return modelAndView;
    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "删除name库存")
    @ApiIgnore()
    public CommonResult<Integer> deleteByName(@RequestParam("id") Integer id, HttpServletRequest request) {
        Integer result = iStorageTableService.deleteById(id, request);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PostMapping("/updateOne")
    @ApiOperation(value = "更新一条记录")
    public CommonResult<Integer> updateByName(@RequestBody StorageTable storageTable,HttpServletRequest request) {
        iStorageTableService.updateOne(storageTable ,request);
        return CommonResult.sucess(iStorageTableService.updateOne(storageTable,request), "本条数据修改成功！");
    }

    @GetMapping("/updateById")
    @ApiOperation(value = "更新一条记录")
    @ResponseBody
    public CommonResult updateById(Integer id,HttpServletRequest request) {
        // 不存在没有数据的
        StorageTable storageTable = iStorageTableService.updateById(id);
        return CommonResult.sucess(storageTable);
    }
}

