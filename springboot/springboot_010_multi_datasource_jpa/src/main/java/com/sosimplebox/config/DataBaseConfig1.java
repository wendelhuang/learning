package com.sosimplebox.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	entityManagerFactoryRef = "entityManagerFactoryDataBase1",
	transactionManagerRef = "transactionManagerDataBase1",
	basePackages = {"com.sosimplebox.dao.db1"}
)
public class DataBaseConfig1 {
	@Autowired
	private DataSource dataBase1DataSource;
	
	@Primary
	@Bean(name = "entityManagerFactoryDataBase1")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryDataBase1(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataBase1DataSource)
				.packages("com.sosimplebox.model.db1")
				.persistenceUnit("dataBase1PersistenceUnit")
				.build();
	}
	
	@Bean(name = "transactionManagerDataBase1")
	PlatformTransactionManager transactionManagerDataBase1(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactoryDataBase1(builder).getObject());
	}
}
