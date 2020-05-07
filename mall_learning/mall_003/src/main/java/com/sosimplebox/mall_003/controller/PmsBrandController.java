package com.sosimplebox.mall_003.controller;

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

import com.sosimplebox.mall_003.common.api.CommonPage;
import com.sosimplebox.mall_003.common.api.CommonResult;
import com.sosimplebox.mall_003.mbg.model.PmsBrand;
import com.sosimplebox.mall_003.service.PmsBrandService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "PmsBrandController", description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
	@Autowired
	private PmsBrandService pmsBrandService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);
	
	@ApiOperation("获取所有品牌列表")
	@RequestMapping(value = "listAll", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<List<PmsBrand>> getBrandList() {
		return CommonResult.success(pmsBrandService.listAllBrand());
	}
	
	@ApiOperation("添加品牌")
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
	
	@ApiOperation("更新指定id品牌信息")
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
	
	@ApiOperation("删除指定id的品牌")
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
	
	@ApiOperation("分页查询品牌列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	@ResponseBody
	public CommonResult listBrand(@RequestParam(value = "pageNum", defaultValue = "1") @ApiParam("页码") Integer pageNum,
									@RequestParam(value = "pageSize", defaultValue = "3") @ApiParam("每页数量") Integer pageSize) {
		List<PmsBrand> brandList = pmsBrandService.listBrand(pageNum, pageSize);
		return CommonResult.success(CommonPage.restPage(brandList));
	}
	
	@ApiOperation("获取指定id的品牌详情")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult brand(@PathVariable("id") Long id) {
		return CommonResult.success(pmsBrandService.getBrand(id));
	}
}