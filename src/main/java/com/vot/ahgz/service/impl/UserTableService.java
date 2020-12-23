package com.vot.ahgz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vot.ahgz.entity.UserTable;
import com.vot.ahgz.mapper.UserTableMapper;
import com.vot.ahgz.service.IUserTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
@Service
public class UserTableService  implements IUserTableService {

    @Autowired
    private UserTableMapper userTableMapper;

    public static QueryWrapper<UserTable> queryWrapper = null;
    @Override
    public List<UserTable> getAll() {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.le("id",1000);
        return userTableMapper.selectList(queryWrapper);
    }

    @Override
    public UserTable getById(Integer id) {

        return userTableMapper.selectById(id);
    }

    @Override
    public List<UserTable> getByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",name);
        return userTableMapper.selectList(queryWrapper);
    }

    @Override
    public Integer insertUserTable(UserTable userTable) {
        queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("username",userTable.getUsername());
        UserTable userTable1 = userTableMapper.selectOne(queryWrapper);
        if (null == userTable1){
            return userTableMapper.insert(userTable);
        }else {
            return 0;
        }
    }

    @Override
    public Integer deleteByName(String name) {
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",name);
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
