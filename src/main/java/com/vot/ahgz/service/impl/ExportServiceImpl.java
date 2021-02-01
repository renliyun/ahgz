package com.vot.ahgz.service.impl;

import com.vot.ahgz.entity.*;
import com.vot.ahgz.service.*;
import org.apache.poi.hssf.record.BookBoolRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author renlirong
 * @Date 2021-1-31
 */
public class ExportServiceImpl implements IExportService {

    @Autowired
    private IStorageTableService iStorageTableService;

    @Autowired
    private IBorrowRecordService iBorrowRecordService;

    @Autowired
    private IInRecordService iInRecordService;

    @Autowired
    private IOutRecordService outRecordService;

    @Autowired
    private IDeliveryRecordService iDeliveryRecordService;

    @Autowired
    private IAddressListService iAddressListService;


    @Override
    public HSSFWorkbook exportStorage(StorageTable storageTable) {
        return null;
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
}
