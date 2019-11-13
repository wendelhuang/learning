package com.sosimplebox.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sosimplebox.model.Order;

@Repository
public class OrderDao {
	/*
	 * @Autowired JdbcTemplate jdbcTemplate;
	 */
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public OrderDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int save(Order order) {
		String sql = "insert into `order` (name, money) values (?, ?)";
		return jdbcTemplate.update(sql, order.getName(), order.getMoney());
	}
	
	public int update(Order order) {
		String sql = "update `order` set money = ? where id = ?";
		return jdbcTemplate.update(sql, order.getMoney(), order.getId());
	}
	
	public int delete(Order order) {
		String sql = "delete from `order` where id = ?";
		return jdbcTemplate.update(sql, order.getId());
	}
	
	public List<Order> findAll() {
		String sql = "select * from `order`";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Order.class));
	}
}
