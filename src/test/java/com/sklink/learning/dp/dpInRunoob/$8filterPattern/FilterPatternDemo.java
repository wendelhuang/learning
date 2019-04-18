package com.sklink.learning.dp.dpInRunoob.$8filterPattern;

import java.util.ArrayList;
import java.util.List;

public class FilterPatternDemo {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Robert", "Male", "Single"));
		people.add(new Person("John", "Male", "Married"));
		people.add(new Person("Laura", "Female", "Married"));
		people.add(new Person("Diana", "Female", "Single"));
		people.add(new Person("Mike", "Male", "Single"));
		people.add(new Person("Bobby", "Male", "Single"));
		
		Criteria male = new CriteriaMale();
		Criteria female = new CriteriaFemale();
		Criteria single = new CriteriaSingle();
		
		Criteria singleMale = new AndCriteria(single, male);
		Criteria singleOrFemale = new OrCriteria(single, female);
		
		System.out.println("Males: ");
		printPeople(male.meetCriteria(people));
		
		System.out.println("Females: ");
		printPeople(female.meetCriteria(people));
		
		System.out.println("Single: ");
		printPeople(single.meetCriteria(people));
		
		System.out.println("SingleMale: ");
		printPeople(singleMale.meetCriteria(people));
		
		System.out.println("SingleOrFemale: ");
		printPeople(singleOrFemale.meetCriteria(people));
	}
	
	public static void printPeople(List<Person> people) {
		for(Person p : people) {
			System.out.println(String.format("Name: %s, Gender: %s, Marital status: %s", p.getName(), p.getGender(), p.getMaritalStatus()));
		}
	}
}
