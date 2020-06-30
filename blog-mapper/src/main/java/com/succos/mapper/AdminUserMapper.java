package com.succos.mapper;

import com.succos.my.mapper.MyMapper;
import com.succos.pojo.AdminPermission;
import com.succos.pojo.AdminRole;
import com.succos.pojo.AdminUser;

import java.util.List;

public interface AdminUserMapper extends MyMapper<AdminUser> {
    AdminUser loadUserByUsername(String username);
    List<AdminRole> getUserRolesByUid(Integer id);
    List<AdminPermission> findPermissionByUserId(String userId);
}