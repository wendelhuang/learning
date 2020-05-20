package com.sosimplebox.p001_helloworld.dao;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable {
	int id;
	String name;
	BigDecimal money;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Order() {
		super();
	}
	public Order(int id, String name, BigDecimal money) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", money=" + money + "]";
	}
}
