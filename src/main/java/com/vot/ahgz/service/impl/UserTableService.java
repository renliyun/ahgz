package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.UserTable;
import com.vot.ahgz.mapper.UserTableMapper;
import com.vot.ahgz.service.IUserTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserTableService implements IUserTableService {

    private static final Logger logger=  LoggerFactory.getLogger(UserTableService.class);

    @Autowired
    private UserTableMapper userTableMapper;

    public static QueryWrapper<UserTable> queryWrapper = null;

    @Override
    public List<UserTable> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id", Integer.MAX_VALUE);
        return userTableMapper.selectList(queryWrapper);
    }

    @Override
    public UserTable getById(Integer id) {
        return userTableMapper.selectById(id);
    }

    @Override
    public UserTable getByName(String name,String password) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", name);
        queryWrapper.eq("password",password);
        return userTableMapper.selectOne(queryWrapper);
    }

    @Override
    public Integer insertUserTable(UserTable userTable) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userTable.getUsername());
        UserTable userTable1 = userTableMapper.selectOne(queryWrapper);
        if (null == userTable1) {
            return userTableMapper.insert(userTable);
        } else {
            return 0;
        }
    }

    @Override
    public Integer deleteByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", name);
        return userTableMapper.delete(queryWrapper);
    }

    @Override
    public Integer deleteById(Integer id) {
        return userTableMapper.deleteById(id);
    }

    @Override
    public Integer updateByName(UserTable userTable) {
        return userTableMapper.updateById(userTable);
    }
}
