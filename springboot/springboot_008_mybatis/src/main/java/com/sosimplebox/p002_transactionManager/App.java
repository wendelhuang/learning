package com.sosimplebox.p002_transactionManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.TransactionDefinition;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		TransactionDefinition t = new TransactionDefinition() {
		};
		SpringApplication.run(App.class);
	}
}
