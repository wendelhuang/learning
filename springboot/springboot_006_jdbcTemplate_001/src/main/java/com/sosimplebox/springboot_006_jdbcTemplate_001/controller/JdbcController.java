package com.sosimplebox.springboot_006_jdbcTemplate_001.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	
	/*
	 * private final JdbcTemplate jdbcTemplate;
	 * 
	 * @Autowired public JdbcController(JdbcTemplate jdbcTemplate) {
	 * this.jdbcTemplate = jdbcTemplate; }
	 */
	
	@GetMapping("/list")
	public List<Map<String, Object>> queryAccount() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from account");
		return list;
	}
}
