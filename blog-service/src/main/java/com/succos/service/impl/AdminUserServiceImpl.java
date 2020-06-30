package com.succos.service.impl;

import com.succos.mapper.AdminUserMapper;
import com.succos.pojo.AdminPermission;
import com.succos.pojo.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author succos
 * @version 1.0
 * @date 2020/6/4 0:04
 */
@Service
public class AdminUserServiceImpl implements UserDetailsService {

    @Autowired
    public AdminUserMapper adminUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
//        String mima = bcryptPasswordEncoder.encode("123");
//        System.out.println(mima);
        AdminUser user = adminUserMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("账户不存在!");
        }

        List<AdminPermission> list = adminUserMapper.findPermissionByUserId(user.getId().toString());
        List<String> permissions = new ArrayList<>();
        for (AdminPermission permission1 : list) {
            permissions.add( permission1.getCode());
        }
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        UserDetails userDetails = org.springframework.security.core.userdetails
                .User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(permissionArray)
                .build();
        return userDetails;
    }


}
