package com.sosimplebox.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosimplebox.model.auto.Account;
import com.sosimplebox.service.IAccountService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author huangww
 * @since 2020-08-21
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	IAccountService accountService;

	@GetMapping("/list")
	public String list() {
		return accountService.list().stream().map(Account::toString).collect(Collectors.joining());
	}
}
