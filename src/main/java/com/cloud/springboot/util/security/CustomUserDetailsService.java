package com.cloud.springboot.util.security;



import com.cloud.springboot.entity.TSysMenu;
import com.cloud.springboot.entity.TSysUser;
import com.cloud.springboot.service.TSysMenuService;
import com.cloud.springboot.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @Description: 认证和授权
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2019/3/21 0021
 * @Version 1.0
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TSysUserService userService;

    @Autowired
    private TSysMenuService menuService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //--------------------认证账号
        TSysUser user = userService.findByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("账号不存在");
        }


        //-------------------开始授权
        List<TSysMenu> menus = menuService.getMenusByUserId(String.valueOf(user.getId()));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (TSysMenu menu : menus) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(menu.getUrl());
            //此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
            grantedAuthorities.add(grantedAuthority);
        }
        user.setAuthorities(grantedAuthorities);
        return user;
    }


}

