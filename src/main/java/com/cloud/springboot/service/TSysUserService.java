package com.cloud.springboot.service;

public interface TSysUserService {
    String getSysUser();

    void saveSysUser(String userName, String password);
}
