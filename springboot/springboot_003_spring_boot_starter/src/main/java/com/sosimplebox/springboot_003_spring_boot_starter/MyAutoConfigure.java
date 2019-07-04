package com.sosimplebox.springboot_003_spring_boot_starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(MyService.class)
@EnableConfigurationProperties(MyProperties.class)
public class MyAutoConfigure {
	@Autowired
	private MyProperties myProperties;
	
	@Bean
	@ConditionalOnMissingBean(MyService.class)
	@ConditionalOnProperty(prefix = "ssb.example", value = "enabled", havingValue = "true")
	public MyService myService() {
		return new MyService(myProperties);
	}
}
