package com.sklink.learning.dp.dpInRunoob.$8filterPattern;

import java.util.List;

public class OrCriteria implements Criteria {
	private Criteria criteria, otherCriteria;
	
	public OrCriteria(Criteria criteria, Criteria otherCriteria) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	@Override
	public List<Person> meetCriteria(List<Person> people) {
		List<Person> firstCriteriaPeople = criteria.meetCriteria(people);
		List<Person> otherCriteriaPeople = otherCriteria.meetCriteria(people);
		
		for(Person p : otherCriteriaPeople) {
			if (!firstCriteriaPeople.contains(p)) {
				firstCriteriaPeople.add(p);
			}
		}
		
		return firstCriteriaPeople;
	}

}
