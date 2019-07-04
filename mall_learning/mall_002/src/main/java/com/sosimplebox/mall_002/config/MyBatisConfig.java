package com.sosimplebox.mall_002.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sosimplebox.mall_002.mbg.mapper")
public class MyBatisConfig {

}
