package com.sklink.learning.dp.dpInRunoob.$9compositePattern;

public class CompositePatternDemo {
	public static void main(String[] args) {
		Employee ceo = new Employee("John", "CEO", 30000);
		Employee headSales = new Employee("Robert", "Head Sales", 20000);
		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);
		
		Employee clerk1 = new Employee("Laura", "Marketing", 10000);
		Employee clerk2 = new Employee("Bob", "Marketing", 10000);
		
		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);
		
		ceo.add(headSales);
		ceo.add(headMarketing);
		
		headSales.add(clerk1);
		headSales.add(clerk2);
		
		headMarketing.add(salesExecutive1);
		headMarketing.add(salesExecutive2);
		
		printEmployee(ceo);
	}
	
	public static void printEmployee(Employee e) {
		System.out.println(e);
		
		for(Employee ee : e.getSubordinates()) {
			printEmployee(ee);
		}
	}
}
