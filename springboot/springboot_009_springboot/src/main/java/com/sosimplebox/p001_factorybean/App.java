package com.sosimplebox.p001_factorybean;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sosimplebox.p001_factorybean.demo.print.IPrint;

@SpringBootApplication
@MapperScan(basePackages = "com.sosimplebox")
public class App {
	public App(IPrint printProxy) {
		printProxy.execute(10, "log info");
		printProxy.execute(0, "console info");
	}
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
