package com.sosimplebox.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	entityManagerFactoryRef = "entityManagerFactoryDataBase2",
	transactionManagerRef = "transactionManagerDataBase2",
	basePackages = {"com.sosimplebox.dao.db2"}
)
public class DataBaseConfig2 {
	@Autowired
	@Qualifier("dataBase2DataSource")
	private DataSource dataBase2DataSource;
	
	@Bean(name = "entityManagerFactoryDataBase2")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryDataBase2(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataBase2DataSource)
				.packages("com.sosimplebox.model.db2")
				.persistenceUnit("dataBase2PersistenceUnit")
				.build();
	}
	
	@Bean(name = "transactionManagerDataBase2")
	PlatformTransactionManager transactionManagerDataBase2(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactoryDataBase2(builder).getObject());
	}
}
