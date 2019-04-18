package com.sklink.learning.dp.dpInRunoob.$8filterPattern;

import java.util.List;

public class AndCriteria implements Criteria {
	private Criteria criteria, otherCriteria;
	
	public AndCriteria(Criteria criteria, Criteria otherCriteria) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	@Override
	public List<Person> meetCriteria(List<Person> people) {
		List<Person> firstCriteriaPeople = criteria.meetCriteria(people);
		return otherCriteria.meetCriteria(firstCriteriaPeople);
	}

}
