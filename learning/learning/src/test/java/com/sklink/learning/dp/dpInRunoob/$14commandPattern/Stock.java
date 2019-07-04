package com.sklink.learning.dp.dpInRunoob.$14commandPattern;

public class Stock {
	private String name = "ABC";
	private int quantity = 10;
	
	public void buy() {
		System.out.println(String.format("Stock name[%s], quantity[%d] bought", this.name, this.quantity));
	}
	
	public void sell() {
		System.out.println(String.format("Stock name[%s], quantity[%d] sold", this.name, this.quantity));
	}
}
