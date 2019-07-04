package com.sosimplebox.mall_001.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sosimplebox.mall_001.mbg.mapper")
public class MyBatisConfig {

}
