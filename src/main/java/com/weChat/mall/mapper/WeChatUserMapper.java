package com.weChat.mall.mapper;

import com.weChat.mall.model.SysRole;
import com.weChat.mall.model.SysUser;
import com.weChat.mall.util.MyMapper;

import java.util.List;

/**
 * Created by tiny on 16/7/17.
 */
public interface WeChatUserMapper{

    SysUser findByUserName(String userName);

    List<SysRole> findRolesByUserId(Long userId);
}
