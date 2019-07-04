package com.sosimplebox.mall_003.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sosimplebox.mall_003.mbg.mapper")
public class MyBatisConfig {

}
