package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.entity.UserTable;
import com.vot.ahgz.mapper.StorageTableMapper;
import com.vot.ahgz.service.IStorageTableService;
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
public class StorageTableService implements IStorageTableService {

    private static final Logger logger = LoggerFactory.getLogger(StorageTableService.class);

    @Autowired
    private StorageTableMapper storageTableMapper;

    public static QueryWrapper<StorageTable> queryWrapper = null;

    @Override
    public List<StorageTable> getAll(StorageTable storageTable) {
        if (null != storageTable) {
            queryWrapper = new QueryWrapper<>();
            //将查询条件放入
            if (!StringUtils.isEmpty(storageTable.getPartName())) {
                System.out.println("========================================" + storageTable.getPartName());
                queryWrapper.eq("part_name", storageTable.getPartName());
            }
            if (null != storageTable.getMatnr()) {
                System.out.println("========================================" + storageTable.getPartName());
                queryWrapper.eq("matnr", storageTable.getMatnr());
            }
            if (!StringUtils.isEmpty(storageTable.getFigureNumber())) {
                queryWrapper.eq("figure_number", storageTable.getFigureNumber());
            }
            if (!StringUtils.isEmpty(storageTable.getSupplier())) {
                queryWrapper.eq("supplier", storageTable.getSupplier());
            }
            if (!StringUtils.isEmpty(storageTable.getLocation())) {
                queryWrapper.eq("location", storageTable.getLocation());
            }
            if (!StringUtils.isEmpty(storageTable.getCreatedName())) {
                queryWrapper.eq("created_name", storageTable.getCreatedName());
            }
            if (!StringUtils.isEmpty(storageTable.getPartSpecification())) {
                queryWrapper.eq("part_specification", storageTable.getPartSpecification());
            }
            if (!StringUtils.isEmpty(storageTable.getCategory())) {
                queryWrapper.eq("category", storageTable.getCategory());
            }
            return storageTableMapper.selectList(queryWrapper);
        } else {
            return null;
        }

    }

    @Override
    public StorageTable getById(Integer id) {

        return storageTableMapper.selectById(id);
    }

    @Override
    public List<StorageTable> getByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return storageTableMapper.selectList(queryWrapper);
    }

    @Override
    public Integer insertStorageTable(StorageTable storageTable) {
        return storageTableMapper.insert(storageTable);
    }

    @Override
    public Integer deleteByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("part_name", name);
        return storageTableMapper.delete(queryWrapper);
    }

    @Override
    public Integer deleteById(Integer id, HttpServletRequest request) {
        // 输入日志
        UserTable userTable = (UserTable) request.getSession().getAttribute("user");
        logger.info("用户名为：" + userTable.getUsername() + "删除id编号为：" + id + "得库存数据！");
        return storageTableMapper.deleteById(id);
    }

    @Override
    public Integer updateOne(StorageTable storageTable, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserTable userTable = (UserTable) httpSession.getAttribute("user");
        logger.info("用户名为:" + userTable.getUsername() + "更新库存信息,数据为：" + storageTable);
        return storageTableMapper.updateById(storageTable);
    }

    @Override
    public StorageTable updateById(Integer id) {
        return storageTableMapper.selectById(id);
    }
}
