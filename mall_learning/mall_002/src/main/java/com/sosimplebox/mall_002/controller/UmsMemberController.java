package com.sosimplebox.mall_002.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sosimplebox.mall_002.common.api.CommonResult;
import com.sosimplebox.mall_002.service.UmsMemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "UmsMemberController", description = "会员登陆注册管理")
@Controller
@RequestMapping("/sso")
public class UmsMemberController {
	
	@Autowired
	private UmsMemberService umsMemberService;
	
	@ApiOperation("获取验证码")
	@RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult getAuthCode(@RequestParam String telephone) {
		return umsMemberService.generateAuthCode(telephone);
	}
	
	@ApiOperation("判断验证码是否正确")
	@RequestMapping(value = "verifyAuthCode", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult updatePassword(@RequestParam String telephone, @RequestParam String authCode) {
		return umsMemberService.verifyAuthCode(telephone, authCode);
	}
}
