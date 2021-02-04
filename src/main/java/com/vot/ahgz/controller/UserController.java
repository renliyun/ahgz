package com.vot.ahgz.controller;


import com.vot.ahgz.common.CommonResult;
import com.vot.ahgz.common.ResultCode;
import com.vot.ahgz.entity.UserTable;
import com.vot.ahgz.service.IUserTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        CommonResult commonResult = new CommonResult();
        commonResult.setData(iUserTableService.getAll());
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage("获取数据成功！");
        return commonResult;
    }

    @PostMapping("/login")
    @ApiOperation(value = "登陆")
    public Integer login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession) {
        UserTable userTable = iUserTableService.getByName(username);
        if (null == userTable) {
            return 0;
        } else {
            httpSession.setAttribute("user", userTable);
            return 1;
        }
    }

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

