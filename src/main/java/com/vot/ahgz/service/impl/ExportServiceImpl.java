package com.vot.ahgz.service.impl;

import com.vot.ahgz.entity.*;
import com.vot.ahgz.service.*;
import org.apache.poi.hssf.record.BookBoolRecord;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * @author renlirong
 * @Date 2021-1-31
 */
@Service
public class ExportServiceImpl implements IExportService {

    @Autowired
    private IStorageTableService iStorageTableService;

    public static HSSFRow hssfRow = null;

    public static HSSFCell hssfCell = null;

    @Override
    public HSSFWorkbook exportStorage(StorageTable storageTable) {
        List<StorageTable> list = iStorageTableService.getAll(storageTable);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("storage");
        //设置内容样式
        HSSFCellStyle contentStyle = createContentCellStyle(hssfWorkbook);
        //创建标题/合并标题单元格
        //创建第一行，索引从0开始
        int rowNum = 0;
        int serialNumber = 1;
        hssfRow = hssfSheet.createRow(rowNum++);
        hssfRow.setHeight((short) 400); //设置行高
        String title = "安徽光智有限公司北京分公司库存表";
        //创建第一列，索引从0开始
        hssfCell = hssfRow.createCell(0);
        hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 10));
        hssfCell.setCellValue(title);
        hssfCell.setCellStyle(createContentCellStyleForTitle(hssfWorkbook));
        // 第二列放表头
        hssfRow = hssfSheet.createRow(rowNum++);
        hssfRow.setHeight((short) 300);
        hssfCell = hssfRow.createCell(0);
        hssfCell.setCellValue("序号");
        hssfCell.setCellStyle(contentStyle);
        hssfSheet.setColumnWidth(0,10 * 256);
        hssfCell = hssfRow.createCell(1);
        hssfCell.setCellValue("物料号");
        hssfCell.setCellStyle(contentStyle);
        hssfSheet.setColumnWidth(1,20 * 256);
        hssfCell = hssfRow.createCell(2);
        hssfCell.setCellValue("图号");
        hssfCell.setCellStyle(contentStyle);
        hssfSheet.setColumnWidth(2,20 * 256);
        hssfCell = hssfRow.createCell(3);
        hssfCell.setCellValue("物料规格");
        hssfCell.setCellStyle(contentStyle);
        hssfSheet.setColumnWidth(3,25 * 256);
        hssfCell = hssfRow.createCell(4);
        hssfCell.setCellValue("零部件名称");
        hssfCell.setCellStyle(contentStyle);
        hssfSheet.setColumnWidth(4,60 * 256);
        hssfCell = hssfRow.createCell(5);
        hssfCell.setCellValue("材料");
        hssfCell.setCellStyle(contentStyle);
        hssfSheet.setColumnWidth(5,10 * 256);
        hssfCell = hssfRow.createCell(6);
        hssfCell.setCellValue("供货商");
        hssfCell.setCellStyle(contentStyle);
        hssfSheet.setColumnWidth(6,30 * 256);
        hssfCell = hssfRow.createCell(7);
        hssfCell.setCellValue("物料类别");
        hssfCell.setCellStyle(contentStyle);
        hssfSheet.setColumnWidth(7,20 * 256);
        hssfCell = hssfRow.createCell(8);
        hssfCell.setCellValue("数量");
        hssfCell.setCellStyle(contentStyle);
        hssfSheet.setColumnWidth(8,10 * 256);
        hssfCell = hssfRow.createCell(9);
        hssfCell.setCellValue("库位");
        hssfCell.setCellStyle(contentStyle);
        hssfSheet.setColumnWidth(9,10 * 256);
        hssfCell = hssfRow.createCell(10);
        hssfCell.setCellValue("备注");
        hssfCell.setCellStyle(contentStyle);
        hssfSheet.setColumnWidth(10,30 * 256);
        // 第三列开始放数据
        for (StorageTable storage : list) {
            hssfRow = hssfSheet.createRow(rowNum++);
            // hssfRow.setHeight((short) 150);
            hssfCell = hssfRow.createCell(0);
            hssfCell.setCellValue(serialNumber++);
            hssfCell.setCellStyle(contentStyle);
            hssfSheet.setColumnWidth(0,10 * 256);
            hssfCell = hssfRow.createCell(1);
            hssfCell.setCellValue(storage.getMatnr());
            hssfCell.setCellStyle(contentStyle);
            hssfSheet.setColumnWidth(1,20 * 256);
            hssfCell = hssfRow.createCell(2);
            hssfCell.setCellValue(storage.getFigureNumber());
            hssfCell.setCellStyle(contentStyle);
            hssfSheet.setColumnWidth(2,20 * 256);
            hssfCell = hssfRow.createCell(3);
            hssfCell.setCellValue(storage.getPartSpecification());
            hssfCell.setCellStyle(contentStyle);
            hssfSheet.setColumnWidth(3,30 * 256);
            hssfCell = hssfRow.createCell(4);
            hssfCell.setCellValue(storage.getPartName());
            hssfCell.setCellStyle(contentStyle);
            hssfSheet.setColumnWidth(4,60 * 256);
            hssfCell = hssfRow.createCell(5);
            hssfCell.setCellValue(storage.getMaterial());
            hssfCell.setCellStyle(contentStyle);
            hssfSheet.setColumnWidth(5,10 * 256);
            hssfCell = hssfRow.createCell(6);
            hssfCell.setCellValue(storage.getSupplier());
            hssfCell.setCellStyle(contentStyle);
            hssfSheet.setColumnWidth(6,30 * 256);
            hssfCell = hssfRow.createCell(7);
            hssfCell.setCellValue(storage.getCategory());
            hssfCell.setCellStyle(contentStyle);
            hssfSheet.setColumnWidth(7,20 * 256);
            hssfCell = hssfRow.createCell(8);
            hssfCell.setCellValue(storage.getNumber());
            hssfCell.setCellStyle(contentStyle);
            hssfSheet.setColumnWidth(8,10 * 256);
            hssfCell = hssfRow.createCell(9);
            hssfCell.setCellValue(storage.getLocation());
            hssfCell.setCellStyle(contentStyle);
            hssfSheet.setColumnWidth(9,10 * 256);
            hssfCell = hssfRow.createCell(10);
            hssfCell.setCellValue(storage.getMark());
            hssfCell.setCellStyle(contentStyle);
            hssfSheet.setColumnWidth(10,40 * 256);
        }
        return hssfWorkbook;
    }

    @Override
    public HSSFWorkbook exportBorrow(BookBoolRecord bookBoolRecord) {
        return null;
    }

    @Override
    public HSSFWorkbook exportInRecord(InRecord inRecord) {
        return null;
    }

    @Override
    public HSSFWorkbook exportOutRecrd(OutRecord outRecord) {
        return null;
    }

    @Override
    public HSSFWorkbook exportDeliveryRecord(DeliveryRecord deliveryRecord) {
        return null;
    }

    @Override
    public HSSFWorkbook exportAddress(AddressList addressList) {
        return null;
    }


    /* 创建内容样式
     * @param wb
     * @return
     */
    private static HSSFCellStyle createContentCellStyle(HSSFWorkbook wb) {
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平居中
        cellStyle.setWrapText(true);// 设置自动换行
        HSSFFont font = wb.createFont(); // 生成14号字体
        font.setColor((short) 0);
        font.setFontHeightInPoints((short) 14);
        cellStyle.setFont(font);
        cellStyle.setFont(font);
        // 设置边框
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 自动换行
        //cellStyle.setWrapText(true);
        return cellStyle;
    }

    /* 创建内容样式
     * @param wb
     * @return
     */
    private static HSSFCellStyle createContentCellStyleForTitle(HSSFWorkbook wb) {
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平居中
        cellStyle.setWrapText(true);// 设置自动换行
        HSSFFont font = wb.createFont(); // 生成14号字体
        font.setColor((short) 0);
        font.setFontHeightInPoints((short) 18);
        cellStyle.setFont(font);
        cellStyle.setFont(font);
        // 设置边框
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 自动换行
        //  cellStyle.setWrapText(true);
        return cellStyle;
    }
}
