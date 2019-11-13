package com.sosimplebox.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sosimplebox.model.Account;

@Repository
public class AccountDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	public int save(Account account) {
		String sql = "insert into account (name, balance) values (?, ?)";
		return jdbcTemplate.update(sql, account.getName(), account.getBalance());
	}
	
	public int update(Account account) {
		String sql = "update account set balance = ? where id = ?";
		return jdbcTemplate.update(sql, account.getBalance(), account.getId());
	}
	
	public int delete(Account account) {
		String sql = "delete from account where id = ?";
		return jdbcTemplate.update(sql, account.getId());
	}
	
	public List<Account> findAll() {
		String sql = "select * from account";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Account.class));
	}
}
