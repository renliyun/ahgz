package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.BorrowRecord;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.entity.UserTable;
import com.vot.ahgz.mapper.BorrowRecordMapper;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IBorrowRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
@Service
public class BorrowRecordService implements IBorrowRecordService {


    private static final Logger logger = LoggerFactory.getLogger(BorrowRecordService.class);

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Autowired
    private StorageTableMapper storageTableMapper;

    public static QueryWrapper<BorrowRecord> queryWrapper = null;

    @Override
    public List<BorrowRecord> getAll(BorrowRecord borrowRecord) {
        // TODO
        queryWrapper = new QueryWrapper<>();
        System.out.println("请求数据===================" + borrowRecord);
        if (null != borrowRecord) {
            //将查询条件放入
            if (!StringUtils.isEmpty(borrowRecord.getPartName())) {
                System.out.println("========================================" + borrowRecord.getPartName());
                queryWrapper.eq("part_name", borrowRecord.getPartName());
            }
            if (null != borrowRecord.getMatnr()) {
                System.out.println("========================================" + borrowRecord.getPartName());
                queryWrapper.eq("matnr", borrowRecord.getMatnr());
            }
            if (!StringUtils.isEmpty(borrowRecord.getFigureNumber())) {
                queryWrapper.eq("figure_number", borrowRecord.getFigureNumber());
            }
            if (!StringUtils.isEmpty(borrowRecord.getSupplier())) {
                queryWrapper.eq("supplier", borrowRecord.getSupplier());
            }
            if (!StringUtils.isEmpty(borrowRecord.getCreatedName())) {
                queryWrapper.eq("created_name", borrowRecord.getCreatedName());
            }
            if (!StringUtils.isEmpty(borrowRecord.getPartSpecification())) {
                queryWrapper.eq("part_specification", borrowRecord.getPartSpecification());
            }
            if (!StringUtils.isEmpty(borrowRecord.getCategory())) {
                queryWrapper.eq("category", borrowRecord.getCategory());
            }
            if (!StringUtils.isEmpty(borrowRecord.getBorrowName())) {
                queryWrapper.eq("borrow_name", borrowRecord.getBorrowName());
            }
        } else {
            queryWrapper.le("id", Integer.MAX_VALUE);
        }
        return borrowRecordMapper.selectList(queryWrapper);
    }

    @Override
    public List<BorrowRecord> getByName(String name) {
        QueryWrapper<BorrowRecord> queryWrapper = new QueryWrapper<>();
        return borrowRecordMapper.selectList(queryWrapper.eq("part_name", name));
    }

    @Override
    public Integer insertBorrowRecord(BorrowRecord borrowRecord , HttpServletRequest request) {
        // TODO 是否有库存可以借用  涉及出库
        try {
            QueryWrapper<StorageTable> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("matnr", borrowRecord.getMatnr());
            StorageTable storageTable = storageTableMapper.selectOne(queryWrapper);
            if (null == storageTable || storageTable.getNumber() < borrowRecord.getNumber()) {
                return 0; //不可借
            } else {
                // 更新库存
                storageTable.setNumber(storageTable.getNumber() - borrowRecord.getNumber());
                storageTableMapper.updateById(storageTable);
                HttpSession httpSession = request.getSession();
                UserTable userTable  = (UserTable) httpSession.getAttribute("user");
                logger.info("借用成功，借用物料号为："+borrowRecord.getMatnr()+"得物料"+borrowRecord.getNumber()+"个,借用人"+userTable.getUsername());
                return borrowRecordMapper.insert(borrowRecord);
            }
        } catch (Exception e) {
            System.out.println("借用错误");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteByName(String name) {
        QueryWrapper<BorrowRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return borrowRecordMapper.delete(queryWrapper);
    }

    @Override
    public Integer deleteById(Integer id) {
        return borrowRecordMapper.deleteById(id);
    }

    @Override
    public Integer updateByName(BorrowRecord borrowRecord) {
        return borrowRecordMapper.updateById(borrowRecord);
    }
}
