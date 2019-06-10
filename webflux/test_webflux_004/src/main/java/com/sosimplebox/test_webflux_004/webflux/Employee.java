package com.sosimplebox.test_webflux_004.webflux;

public class Employee {
	private String id;
	private String name;
	public Employee() {
		super();
	}
	public Employee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee e = (Employee)obj;
		return this.id.equals(e.id) && this.name.equals(e.name);
	}
}
