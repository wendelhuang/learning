package com.sosimplebox.test_webflux_003.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosimplebox.test_webflux_003.domain.City;
import com.sosimplebox.test_webflux_003.handler.CityHandler;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/city")
public class CityController {
	@Autowired
	public CityHandler cityHandler;
	
	@GetMapping(value = "/{id}")
	public Mono<City> getById(@PathVariable("id")Long id){
		return cityHandler.getById(id);
	}
	
	@GetMapping()
	public Flux<City> listAll() {
		return cityHandler.listAll();
	}
	
	@PostMapping()
	public Mono<Long> save(@RequestBody City city) {
		return cityHandler.save(city);
	}
	
	@PutMapping()
	public Mono<Long> update(@RequestBody City city) {
		return cityHandler.update(city);
	}
	
	@DeleteMapping(value="/{id}")
	public Mono<Long> delete(@PathVariable("id") Long id){
		return cityHandler.deleteById(id);
	}
}
