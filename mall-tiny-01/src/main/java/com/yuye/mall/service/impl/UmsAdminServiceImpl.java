package com.yuye.mall.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.yuye.mall.mapper.UmsAdminMapper;
import com.yuye.mall.mapper.UmsPermissionMapper;
import com.yuye.mall.model.UmsAdmin;
import com.yuye.mall.model.UmsAdminExample;
import com.yuye.mall.model.UmsPermission;
import com.yuye.mall.model.UmsPermissionExample;
import com.yuye.mall.service.UmsAdminService;
import com.yuye.mall.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author yuye
 * @Date 2020/9/28 11:05 上午
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Autowired
    private UmsPermissionMapper umsPermissionMapper;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample umsAdminExample = new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(username);
        return umsAdminMapper.selectByExample(umsAdminExample).get(0);
    }

    @Override
    public List<UmsPermission> getPermissionList(Long id) {
        UmsPermissionExample umsPermissionExample = new UmsPermissionExample();
        umsPermissionExample.createCriteria().andIdEqualTo(id);
        return umsPermissionMapper.selectByExample(umsPermissionExample);
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        umsAdminParam.setCreateTime(new Date());
        umsAdminParam.setStatus(1);
        UmsAdminExample umsAdminExample = new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(umsAdminParam.getUsername());
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectByExample(umsAdminExample);
        if (CollectionUtil.isNotEmpty(umsAdmins)) {
            return null;
        }
        umsAdminParam.setPassword(passwordEncoder.encode(umsAdminParam.getPassword()));
        int i = umsAdminMapper.insertSelective(umsAdminParam);
        if (i > 0) {
            return umsAdminParam;
        } else {
            return null;
        }
    }

    @Override
    public String login(String username, String password) {
        String token=null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                return "密码不正确";
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
        return token;
    }
}
