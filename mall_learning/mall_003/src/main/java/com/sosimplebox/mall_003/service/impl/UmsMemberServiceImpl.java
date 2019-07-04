package com.sosimplebox.mall_003.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sosimplebox.mall_003.common.api.CommonResult;
import com.sosimplebox.mall_003.service.RedisService;
import com.sosimplebox.mall_003.service.UmsMemberService;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {
	
	@Autowired
	private RedisService redisService;
	@Value("${redis.key.prefix.authCode}")
	private String REDIS_KEY_PREFIX_AUTHCODE;
	@Value("${redis.key.expire.authCode}")
	private Long REDIS_KEY_EXPIRE_AUTHCODE;

	@Override
	public CommonResult generateAuthCode(String telephone) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			sb.append(random.nextInt(10));
		}
		redisService.set(REDIS_KEY_PREFIX_AUTHCODE + telephone, sb.toString());
		redisService.expire(REDIS_KEY_PREFIX_AUTHCODE + telephone, REDIS_KEY_EXPIRE_AUTHCODE);
		return CommonResult.success(sb.toString(), "获取验证码成功");
	}

	@Override
	public CommonResult verifyAuthCode(String telephone, String authCode) {
		if (StringUtils.isEmpty(authCode)) {
			return CommonResult.failed("请输入验证码");
		}
		String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTHCODE + telephone);
		if (authCode.equals(realAuthCode)) {
			return CommonResult.success(null, "验证码校验成功");
		}else {
			return CommonResult.failed("验证码不正确");
		}
	}

}
