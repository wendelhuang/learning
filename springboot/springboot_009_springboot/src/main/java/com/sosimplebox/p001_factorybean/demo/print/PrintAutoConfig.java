package com.sosimplebox.p001_factorybean.demo.print;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.sosimplebox.p001_factorybean.engine.SpiFactoryBean;

@Configuration
public class PrintAutoConfig {
	@Bean
	public SpiFactoryBean printSpiProxy(ApplicationContext applicationContext) {
		return new SpiFactoryBean<>(applicationContext, IPrint.class);
	}
	
	@Bean
	@Primary
	public IPrint printProxy(SpiFactoryBean spiFactoryBean) throws Exception {
		return (IPrint) spiFactoryBean.getObject();
	}
}
