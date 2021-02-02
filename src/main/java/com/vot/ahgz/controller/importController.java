package com.vot.ahgz.controller;


import com.vot.ahgz.entity.Page;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.service.IExportService;
import com.vot.ahgz.service.IImportService;
import com.vot.ahgz.service.IStorageTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;


@RestController
@RequestMapping("/import")
@Api("工具类，导入数据")
public class importController {


    @Autowired
    private IImportService iImportService;


    // 库存导出
    @PostMapping("/storage")
    @ApiOperation(value = "库存数据导入 '0'代表格式错误或者数据导入失败 大于0 说明导入数据为该数")
    public Integer exportStorage(MultipartFile excelFile) throws IOException {

      return iImportService.importStorage(excelFile);
    }
}
