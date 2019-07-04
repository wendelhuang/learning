package com.sosimplebox.mall_002.service;

import com.sosimplebox.mall_002.common.api.CommonResult;

public interface UmsMemberService {
	CommonResult generateAuthCode(String telephone);
	CommonResult verifyAuthCode(String telephone, String authCode);
}
