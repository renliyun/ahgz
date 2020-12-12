package com.vot.ahgz.service.impl;

import com.vot.ahgz.entity.UserTable;
import com.vot.ahgz.mapper.UserTableMapper;
import com.vot.ahgz.service.IUserTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Override
    public List<UserTable> getAll() {
        return null;
    }

    @Override
    public UserTable getById(Integer id) {
        return null;
    }

    @Override
    public List<UserTable> getByName(String name) {
        return null;
    }

    @Override
    public Integer insertUserTable(UserTable userTable) {
        return null;
    }

    @Override
    public Integer deleteByName(String name) {
        return null;
    }

    @Override
    public UserTable updateByName(String name, UserTable userTable) {
        return null;
    }
}
