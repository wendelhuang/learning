package com.sosimplebox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sosimplebox.dao.AccountDao;
import com.sosimplebox.model.Account;

@Service
public class AccountPropagationNestedService {
	@Autowired
	private AccountDao accountDao;
	
	@Transactional(propagation = Propagation.NESTED)
	public int save(Account account) {
		return accountDao.save(account);
	}
	@Transactional(propagation = Propagation.NESTED)
	public int saveWithException(Account account) {
		int result = accountDao.save(account);
		int d = 10/0;
		return result;
	}
}
