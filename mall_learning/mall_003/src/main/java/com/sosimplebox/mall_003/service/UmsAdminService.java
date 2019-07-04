package com.sosimplebox.mall_003.service;

import java.util.List;

import com.sosimplebox.mall_003.mbg.model.UmsAdmin;
import com.sosimplebox.mall_003.mbg.model.UmsPermission;

public interface UmsAdminService {
	UmsAdmin getAdminByUsername(String username);
	
	UmsAdmin register(UmsAdmin umsAdmin);
	
	String login(String username, String password);
	
	List<UmsPermission> getPermissionList(Long adminId);
}
