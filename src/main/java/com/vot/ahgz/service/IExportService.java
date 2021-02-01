package com.vot.ahgz.service;

import com.vot.ahgz.entity.*;
import org.apache.poi.hssf.record.BookBoolRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author renlirong
 * @since 2021-1-31
 */
public interface IExportService {

    // 导出库存
    HSSFWorkbook exportStorage(StorageTable storageTable);

    // 导出借用
    HSSFWorkbook exportBorrow(BookBoolRecord bookBoolRecord);

    // 导出入库记录
    HSSFWorkbook exportInRecord(InRecord inRecord);

    // 导出出库记录
    HSSFWorkbook exportOutRecrd(OutRecord outRecord);

    // 导出发货记录
    HSSFWorkbook exportDeliveryRecord(DeliveryRecord deliveryRecord);

    // 导出地址数据
    HSSFWorkbook exportAddress(AddressList addressList);

}
