package com.sklink.learning.dp.dpInRunoob.$9compositePattern;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private String dept;
	private int salary;
	private List<Employee> subordinates;
	
	public Employee(String name, String dept, int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.subordinates = new ArrayList<>();
	}
	
	public void add(Employee e) {
		subordinates.add(e);
	}
	
	public void remove(Employee e) {
		subordinates.remove(e);
	}
	
	public List<Employee> getSubordinates() {
		return this.subordinates;
	}
	
	public String toString() {
		return String.format("Name: %s, dept: %s, salary: %d", this.name, this.dept, this.salary);
	}
}
