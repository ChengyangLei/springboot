package com.cloud.springboot.service.imp;

import com.cloud.springboot.dao.TSysMenuMapper;
import com.cloud.springboot.entity.TSysMenu;
import com.cloud.springboot.service.TSysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: TSysMenuServiceImp
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2019/3/21 0021
 * @Version 1.0
 */
@Service
@Transactional
public class TSysMenuServiceImp implements TSysMenuService {

    @Autowired
    private TSysMenuMapper tSysMenuMapper;

    @Override
    public List<TSysMenu> getMenusByUserId(String id) {
        return tSysMenuMapper.getMenusByUserId(id);
    }
}
