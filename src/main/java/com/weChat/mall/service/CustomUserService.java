package com.weChat.mall.service;

import com.weChat.mall.mapper.WeChatUserMapper;
import com.weChat.mall.model.SysRole;
import com.weChat.mall.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiny on 16/7/17.
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    private WeChatUserMapper weChatUserMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser user = weChatUserMapper.findByUserName(userName);
        List<SysRole> list= new ArrayList<>();
        SysRole role = new SysRole();
        role.setId(1l);
        role.setName("ROLE_ADMIN");
        list.add(role);
        user.setRoles(list);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在!");
        }else {
            List<SysRole> roles = weChatUserMapper.findRolesByUserId(user.getId());
            user.setRoles(roles);
        }
        return user;
    }
}
