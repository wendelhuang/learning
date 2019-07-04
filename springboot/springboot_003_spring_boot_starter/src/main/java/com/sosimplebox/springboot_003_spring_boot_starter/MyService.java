package com.sosimplebox.springboot_003_spring_boot_starter;

import java.util.Date;


public class MyService {
	
	private String host;
	private int port;
	public MyService(MyProperties myProperties) {
		this.host = myProperties.getHost();
		this.port = myProperties.getPort();
	}
	
	public void print() {
		System.out.println(String.format("%s: host = %s, port = %d", new Date(), this.host, this.port));
	}
}
