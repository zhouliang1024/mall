package com.yuye.mall.servce;

import com.yuye.mall.api.CommonResult;
import com.yuye.mall.model.UmsMember;

/**
 * @Author: zhouliang
 * @Date: 2020/9/24 22:48
 */
public interface UmsMemberService {
    UmsMember findById(Long id);
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
