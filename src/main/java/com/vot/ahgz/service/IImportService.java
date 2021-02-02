package com.vot.ahgz.service;

import com.vot.ahgz.entity.*;
import org.apache.poi.hssf.record.BookBoolRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author renlirong
 * @since 2021-1-31
 */
public interface IImportService {

    // 导入库存
    Integer importStorage(  MultipartFile excelFile) throws IOException;

}
