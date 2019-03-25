package com.cloud.springboot.service.imp;

import com.cloud.springboot.dao.TSysUserMapper;
import com.cloud.springboot.entity.TSysUser;
import com.cloud.springboot.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: TSysUserServiceImp
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2019/3/21 0021
 * @Version 1.0
 */
@Service
@Transactional
public class TSysUserServiceImp implements TSysUserService {

    @Autowired
    private TSysUserMapper tSysUserMapper;

    @Override
    public TSysUser findByUserName(String userName) {
        return tSysUserMapper.findByUserName(userName);
    }

    @Override
    public String getSysUser(String id) {
        TSysUser tSysUser = tSysUserMapper.selectByPrimaryKey(Long.valueOf(id));
        return tSysUser.getNickname();
    }

    @Override
    public List<TSysUser> getAllUsers() {
        return tSysUserMapper.getAllUsers();
    }

}
