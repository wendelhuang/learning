package com.sosimplebox.mall_000.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sosimplebox.mall_000.mbg.mapper")
public class MyBatisConfig {

}
