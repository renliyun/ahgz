package com.vot.ahgz.service.impl;

import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IImportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;


@Service
public class ImportService implements IImportService {

    public static StorageTable storageTable = null;

    @Autowired
    private StorageTableMapper storageTableMapper;

    @Override
    public Integer importStorage(MultipartFile excelFile) throws IOException {

        // 获取文件名称
        String fileNmae = excelFile.getOriginalFilename();
        // 获取文件类型
        String fileType = fileNmae.substring(fileNmae.lastIndexOf(".")+1);
        // 判断文件格式
        if (!fileType.equals("xls") && !fileType.equals("xlsx")){
            return 0;  // 需要说明文件格式不正确 或者前端就先定好文件格式
        }
        // 用来记录导入得数据条数
        int count = 0;
        try {
            // 读取文件
            InputStream inputStream = excelFile.getInputStream();
            Workbook workbook = null;
            // 选取版本
            if (fileType.equals("xls")){
                // 03及其以下版本
                workbook = new HSSFWorkbook(inputStream);
            }
            if (fileType.equals("xlsx")){
                // 07及以上版本
                workbook = new XSSFWorkbook(inputStream);
            }
            // 读取表格 就一个
            Sheet sheet = workbook.getSheetAt(0);
            // 从第三行开始读取
            for (int i=2;i<= sheet.getLastRowNum();i++){
                // 获取第一行
                Row row = sheet.getRow(i);
                // 第一列
                // 给到库存对象
                storageTable = new StorageTable();
                storageTable.setMatnr(Integer.parseInt( row.getCell(1).getStringCellValue()));
                storageTable.setFigureNumber(row.getCell(2).getStringCellValue());
                storageTable.setPartSpecification(row.getCell(3).getStringCellValue());
                storageTable.setPartName(row.getCell(4).getStringCellValue());
                storageTable.setMaterial(row.getCell(5).getStringCellValue());
                storageTable.setSupplier(row.getCell(6).getStringCellValue());
                storageTable.setCategory(row.getCell(7).getStringCellValue());
                storageTable.setNumber(Integer.parseInt(row.getCell(8).getStringCellValue()));
                storageTable.setLocation(row.getCell(9).getStringCellValue());
                storageTable.setMark("批量导入数据");
                storageTable.setCreatedTime(new Date(System.currentTimeMillis()));
                storageTable.setCreatedName("任利荣");
                storageTableMapper.insert(storageTable);
                count ++;
            }

        }catch (Exception e){
           e.printStackTrace();
        }
        return count;
    }
}
