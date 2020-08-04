package com.sosimplebox.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	@Autowired
	private DataBase1Properties dataBase1Properties;
	
	@Autowired
	private DataBase2Properties dataBase2Properties;
	
	@Bean(name = "dataBase1DataSource")
	@Primary
	public DataSource dataBase1DataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(dataBase1Properties.getUrl());
		dataSource.setUsername(dataBase1Properties.getUsername());
		dataSource.setPassword(dataBase1Properties.getPassword());
		dataSource.setDriverClassName(dataBase1Properties.getDriverClassName());
		return dataSource;
	}
	
	@Bean(name = "dataBase2DataSource")
	public DataSource dataBase2DataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(dataBase2Properties.getUrl());
		dataSource.setUsername(dataBase2Properties.getUsername());
		dataSource.setPassword(dataBase2Properties.getPassword());
		dataSource.setDriverClassName(dataBase2Properties.getDriverClassName());
		return dataSource;
	}
}
