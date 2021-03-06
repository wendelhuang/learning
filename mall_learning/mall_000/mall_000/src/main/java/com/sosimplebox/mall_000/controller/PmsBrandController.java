package com.sosimplebox.mall_000.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sosimplebox.mall_000.common.api.CommonPage;
import com.sosimplebox.mall_000.common.api.CommonResult;
import com.sosimplebox.mall_000.mbg.model.PmsBrand;
import com.sosimplebox.mall_000.service.PmsBrandService;

@Controller
@RequestMapping("/brand")
public class PmsBrandController {
	@Autowired
	private PmsBrandService pmsBrandService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);
	
	@RequestMapping(value = "listAll", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<List<PmsBrand>> getBrandList() {
		return CommonResult.success(pmsBrandService.listAllBrand());
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
		CommonResult commonResult;
		int count = pmsBrandService.createBrand(pmsBrand);
		if (count == 0) {
			commonResult = CommonResult.success(pmsBrand);
			LOGGER.debug("createBrand success: {}", pmsBrand);
		}else {
			commonResult = CommonResult.failed("操作失败");
			LOGGER.debug("createBrand failed: {}", pmsBrand);
		}
		return commonResult;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrand, BindingResult result) {
		CommonResult commonResult;
		int count = pmsBrandService.updateBrand(id, pmsBrand);
		if (count == 0) {
			commonResult = CommonResult.success(pmsBrand);
			LOGGER.debug("updateBrand success: {}", pmsBrand);
		}else {
			commonResult = CommonResult.failed("操作失败");
			LOGGER.debug("updateBrand failed: {}", pmsBrand);
		}
		return commonResult;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult deleteBrand(@PathVariable("id") Long id) {
		int count = pmsBrandService.deleteBrand(id);
		if (count == 1) {
			LOGGER.debug("deleteBrand success :id={}", id);
			return CommonResult.success(null);
		}else {
			LOGGER.debug("deleteBrand failed :id={}", id);
			return CommonResult.failed("操作失败");
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	@ResponseBody
	public CommonResult listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
									@RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
		List<PmsBrand> brandList = pmsBrandService.listBrand(pageNum, pageSize);
		return CommonResult.success(CommonPage.restPage(brandList));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult brand(@PathVariable("id") Long id) {
		return CommonResult.success(pmsBrandService.getBrand(id));
	}
}
