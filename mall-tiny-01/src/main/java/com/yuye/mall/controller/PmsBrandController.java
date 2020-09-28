package com.yuye.mall.controller;

import com.yuye.mall.api.CommonResult;
import com.yuye.mall.model.PmsBrand;
import com.yuye.mall.service.PmsBrandService;
import com.yuye.mall.vo.res.PmsBrandVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhouliang
 * @Date: 2020/9/24 21:53
 */
@RestController
@Api(tags = "PmsBrandController",description = "品牌管理")
@RequestMapping(value = "/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;
    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    @ApiOperation("查询商品")
    public CommonResult<PmsBrandVO> findById(@PathVariable("id") Long id){
        PmsBrand pmsBrand = pmsBrandService.getPmsBrandById(id);
        PmsBrandVO pmsBrandVO = new PmsBrandVO();
        BeanUtils.copyProperties(pmsBrand,pmsBrandVO);
        return CommonResult.success(pmsBrandVO);
    }
}
