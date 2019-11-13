package com.sosimplebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sosimplebox.dao.AccountDao;
import com.sosimplebox.model.Account;

@Service
public class AccountPropagationRequiredService {
	@Autowired
	private AccountDao accountDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int save(Account account) {
		return accountDao.save(account);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveWithException(Account account) {
		int result = accountDao.save(account);
		int d = 10/0;
		return result;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public int update(Account account) {
		return accountDao.update(account);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public int delete(Account account) {
		return accountDao.delete(account);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Account> findAll() {
		return accountDao.findAll();
	}
}
