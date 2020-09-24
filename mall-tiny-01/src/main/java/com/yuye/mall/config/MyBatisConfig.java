package com.yuye.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yuye
 * @Date 2020/9/24 8:20 下午
 */
@Configuration
@MapperScan("com.yuye.mall.mapper")
public class MyBatisConfig {
}
