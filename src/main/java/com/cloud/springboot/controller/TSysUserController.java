package com.cloud.springboot.controller;


import com.cloud.springboot.service.TSysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="/sysUserController", tags="用户接口")
@RestController
@RequestMapping("/sysUserController")
public class TSysUserController {


    @Autowired
    private TSysUserService tSysUserService;

    @ApiOperation(value="查找用户信息", notes = "查找用户信息")
    @GetMapping("/getSysUser")
    public String getSysUser(){
        return tSysUserService.getSysUser();
    }


    @ApiOperation(value="保存用户信息", notes = "保存用户信息")
    @PostMapping("/saveSysUser")
    public void saveSysUser(){
        String userName="test";
        String password="a";
        //对密码进行 md5 加密
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        tSysUserService.saveSysUser(userName,md5Password);
    }

}
