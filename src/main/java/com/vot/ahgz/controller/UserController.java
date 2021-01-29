package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.StorageTable;
import com.vot.ahgz.entity.UserTable;
import com.vot.ahgz.service.IUserTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author renlirong
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/admin")
@Api("用户信息")
public class UserController {

    @Autowired
    private IUserTableService iUserTableService;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有用户")
    public CommonResult<List<UserTable>> getAll() {
        System.out.println("进入controller层了！");
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iUserTableService.getAll());
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }

    @PostMapping("/login")
    @ApiOperation(value = "登陆")
    public Integer login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession) {

        System.out.println("用户名：" + username + "；密码为：" + password);
        UserTable userTable = iUserTableService.getByName(username);
        httpSession.setAttribute("user", userTable);

        System.out.println("用户名：" + username + "；密码为：" + password);

        return 1;
    }


//    @GetMapping("/getOneByName")
//    @ApiOperation(value = "获取name的用户信息")
//    public CommonResult<List<UserTable>> getByName(@RequestParam("name") String name) {
//        return CommonResult.sucess(iUserTableService.getByName(name), "获取用户" + name + "数据成功");
//    }

    @PostMapping("/insertDate")
    @ApiOperation(value = "插入一条用户信息")
    public CommonResult<Integer> insertAddressList(@ModelAttribute UserTable userTable) {
        return CommonResult.sucess(iUserTableService.insertUserTable(userTable), "用户数据插入成功");
    }

    @PostMapping("/deleteByName")   //不建议使用
    @ApiOperation(value = "删除用户")
    public CommonResult<Integer> deleteByName(@RequestParam("name") String name) {
        Integer result = iUserTableService.deleteByName(name);
        return result > 0 ? CommonResult.sucess(1) : CommonResult.failed("用户数据删除失败！");
    }

    @PatchMapping("/updateByName")
    @ApiOperation(value = "更新用户")
    public CommonResult<Integer> updateByName(@ModelAttribute UserTable userTable) {
        iUserTableService.updateByName(userTable);
        return CommonResult.sucess(iUserTableService.updateByName(userTable), "用户数据修改成功");
    }
}

