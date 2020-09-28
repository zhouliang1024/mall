package com.yuye.mall.service.impl;

import com.yuye.mall.mapper.PmsBrandMapper;
import com.yuye.mall.model.PmsBrand;
import com.yuye.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhouliang
 * @Date: 2020/9/24 21:49
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper pmsBrandMapper;
    @Override
    public PmsBrand getPmsBrandById(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
