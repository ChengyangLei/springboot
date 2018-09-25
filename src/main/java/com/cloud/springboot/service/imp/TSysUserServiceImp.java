package com.cloud.springboot.service.imp;


import com.cloud.springboot.dao.DsePipeBaseinfoMapper;
import com.cloud.springboot.dao.TSysUserMapper;
import com.cloud.springboot.entity.TSysUser;
import com.cloud.springboot.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class TSysUserServiceImp  implements TSysUserService {

    @Autowired
    private TSysUserMapper tSysUserMapper;

    @Override
    public String getSysUser() {
        TSysUser tSysUser = tSysUserMapper.selectByPrimaryKey("1");
        return tSysUser.getUserName();
    }

    @Override
    public void saveSysUser(String userName, String password) {
        TSysUser tSysUser = new TSysUser();
        tSysUser.setUserName(userName);
        tSysUser.setPassword(password);
        tSysUser.setId(UUID.randomUUID().toString());
        tSysUserMapper.insert(tSysUser);
    }
}
