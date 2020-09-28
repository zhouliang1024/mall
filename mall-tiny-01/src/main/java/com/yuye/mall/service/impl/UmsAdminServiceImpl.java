package com.yuye.mall.service.impl;

import com.yuye.mall.mapper.UmsAdminMapper;
import com.yuye.mall.mapper.UmsPermissionMapper;
import com.yuye.mall.model.UmsAdmin;
import com.yuye.mall.model.UmsAdminExample;
import com.yuye.mall.model.UmsPermission;
import com.yuye.mall.model.UmsPermissionExample;
import com.yuye.mall.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yuye
 * @Date 2020/9/28 11:05 上午
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
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
}
