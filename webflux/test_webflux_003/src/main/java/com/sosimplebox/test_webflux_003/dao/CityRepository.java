package com.sosimplebox.test_webflux_003.dao;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.sosimplebox.test_webflux_003.domain.City;

@Repository
public class CityRepository {
	private ConcurrentMap<Long, City> repository = new ConcurrentHashMap();
	
	private static final AtomicLong idGenerator = new AtomicLong(0);
	
	public Long save(City city) {
		Long id = idGenerator.incrementAndGet();
		city.setId(id);
		repository.put(id, city);
		return id;
	}
	
	public Collection<City> listAll() {
		return repository.values();
	}
	
	public City getById(Long id) {
		return repository.get(id);
	}
	
	public Long update(City city) {
		repository.put(city.getId(), city);
		return city.getId();
	}
	public Long deleteById(Long id) {
		repository.remove(id);
		return id;
	}
}
