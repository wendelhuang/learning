package com.sosimplebox.p005_import.part1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import({MyClass.class})
public class TestDemo {
	@Bean
	public AccountDao accountDao() {
		return new AccountDao();
	}
}
