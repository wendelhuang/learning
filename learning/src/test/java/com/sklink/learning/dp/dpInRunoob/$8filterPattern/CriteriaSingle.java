package com.sklink.learning.dp.dpInRunoob.$8filterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria{

	@Override
	public List<Person> meetCriteria(List<Person> people) {
		List<Person> singlePeople = new ArrayList<>();
		for(Person p : people) {
			if (p.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
				singlePeople.add(p);
			}
		}
		return singlePeople;
	}

}
