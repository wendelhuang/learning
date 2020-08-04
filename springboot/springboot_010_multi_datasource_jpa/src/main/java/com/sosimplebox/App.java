package com.sosimplebox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.sosimplebox.config.DataBase1Properties;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@SpringBootApplication
public class App {
	
	@Autowired
	static DataBase1Properties dataBase1Properties;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		
		System.out.println(dataBase1Properties);
	}
}
