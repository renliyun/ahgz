package com.vot.ahgz.controller;


import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.service.IExportService;
import com.vot.ahgz.service.IStorageTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.http.HttpResponse;


@RestController
@RequestMapping("/export")
@Api("工具类，导出数据")
public class ExportController {


    @Autowired
    private IExportService iExportService;


    // 库存导出
    @PostMapping("/storage")
    @ApiOperation(value = "库存数据导出")
    public void exportStorage(@ModelAttribute StorageTable storageTable , HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.printf("storage"+storageTable);
        HSSFWorkbook hssfWorkbook =  iExportService.exportStorage(storageTable);
        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        String filename = "storage.xls";//设置下载时客户端Excel的名称
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + filename);
        // 将文件输出
        hssfWorkbook.write(output);
        output.flush();
        output.close();

    }
}
