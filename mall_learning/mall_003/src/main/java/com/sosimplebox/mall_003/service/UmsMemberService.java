package com.sosimplebox.mall_003.service;

import com.sosimplebox.mall_003.common.api.CommonResult;

public interface UmsMemberService {
	CommonResult generateAuthCode(String telephone);
	CommonResult verifyAuthCode(String telephone, String authCode);
}
