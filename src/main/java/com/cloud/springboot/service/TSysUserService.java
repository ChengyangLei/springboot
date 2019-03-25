package com.cloud.springboot.service;

import com.cloud.springboot.entity.TSysUser;

import java.util.List;

/**
 * @Description: TSysUserService
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2019/3/21 0021
 * @Version 1.0
 */
public interface TSysUserService {
    TSysUser findByUserName(String s);

    String getSysUser(String id);

    List<TSysUser> getAllUsers();

}
