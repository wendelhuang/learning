package com.sklink.learning.dp.dpInRunoob.$8filterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> people) {
		List<Person> femalePeople = new ArrayList<>();
		for(Person p : people) {
			if (p.getGender().equalsIgnoreCase("FEMALE")) {
				femalePeople.add(p);
			}
		}
		return femalePeople;
	}

}
