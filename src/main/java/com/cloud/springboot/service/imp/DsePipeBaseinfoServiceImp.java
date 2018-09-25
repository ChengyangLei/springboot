package com.cloud.springboot.service.imp;

import com.cloud.springboot.dao.DsePipeBaseinfoMapper;
import com.cloud.springboot.entity.DsePipeBaseinfo;
import com.cloud.springboot.service.DsePipeBaseinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DsePipeBaseinfoServiceImp implements DsePipeBaseinfoService {

    @Autowired
    private DsePipeBaseinfoMapper dsePipeBaseinfoMapper;

    @Override
    public String getPipeBaseInfo(){
        DsePipeBaseinfo dsePipeBaseinfo = dsePipeBaseinfoMapper.selectByPrimaryKey("74BCD6C85135453AE055000000000001");
        return dsePipeBaseinfo.getPipeName();
    }

}
