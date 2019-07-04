package com.sosimplebox.mall_003.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sosimplebox.mall_003.common.utils.JwtTokenUtil;
import com.sosimplebox.mall_003.mbg.mapper.UmsAdminMapper;
import com.sosimplebox.mall_003.mbg.model.UmsAdmin;
import com.sosimplebox.mall_003.mbg.model.UmsPermission;
import com.sosimplebox.mall_003.service.UmsAdminService;

public class UmsAdminServiceImpl implements UmsAdminService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Value("${jwt.tokenHead}")
	private String tokenHead;
	
	@Autowired
	private UmsAdminMapper umsAdminMapper;
	
	@Autowired
	private UmsAdminRoleRelation


	@Override
	public UmsAdmin getAdminByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UmsAdmin register(UmsAdmin umsAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UmsPermission> getPermissionList(Long adminId) {
		// TODO Auto-generated method stub
		return null;
	}

}
