package com.sosimplebox.mall_003.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sosimplebox.mall_003.mbg.model.UmsPermission;


public interface UmsAdminRoleRelationDao {
	List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
