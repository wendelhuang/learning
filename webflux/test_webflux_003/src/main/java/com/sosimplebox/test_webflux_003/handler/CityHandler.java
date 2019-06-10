package com.sosimplebox.test_webflux_003.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sosimplebox.test_webflux_003.dao.CityRepository;
import com.sosimplebox.test_webflux_003.domain.City;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CityHandler {

	private final CityRepository cityRepository;
	
	@Autowired
	public CityHandler(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	public Mono<Long> save(City city) {
		return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.save(city)));
	}
	
	public Mono<City> getById(Long id) {
		return Mono.justOrEmpty(cityRepository.getById(id));
	}
	
	public Flux<City> listAll() {
		return Flux.fromIterable(cityRepository.listAll());
	}
	
	public Mono<Long> update(City city) {
		return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.update(city)));
	}
	
	public Mono<Long> deleteById(Long id) {
		return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.deleteById(id)));
	}
}
