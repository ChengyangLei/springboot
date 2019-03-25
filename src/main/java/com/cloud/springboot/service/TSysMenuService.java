package com.cloud.springboot.service;

import com.cloud.springboot.entity.TSysMenu;


import java.util.List;

public interface TSysMenuService {

    List<TSysMenu> getMenusByUserId(String id);
}
