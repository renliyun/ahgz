package com.vot.ahgz.controller;



import com.vot.ahgz.service.IImportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;



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
