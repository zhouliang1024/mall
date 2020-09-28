package com.yuye.mall.service;

import com.yuye.mall.model.UmsAdmin;
import com.yuye.mall.model.UmsPermission;

import java.util.List;

/**
 * @Author yuye
 * @Date 2020/9/28 11:05 上午
 */
public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String username);

    List<UmsPermission> getPermissionList(Long id);
}
