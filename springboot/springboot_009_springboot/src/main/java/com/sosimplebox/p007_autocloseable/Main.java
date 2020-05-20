package com.sosimplebox.p007_autocloseable;

public class Main {
	public static void main(String[] args) {
		System.out.println("begin");
		try(AC1 ac1 = new AC1(); AC2 ac2 = new AC2()) {
			System.out.println("main");
			System.out.println(ac1);
			System.out.println(ac2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
