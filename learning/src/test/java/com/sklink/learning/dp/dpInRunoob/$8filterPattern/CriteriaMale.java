package com.sklink.learning.dp.dpInRunoob.$8filterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> people) {
		List<Person> malePeople = new ArrayList<>();
		for(Person p : people) {
			if (p.getGender().equalsIgnoreCase("MALE")) {
				malePeople.add(p);
			}
		}
		return malePeople;
	}

}
