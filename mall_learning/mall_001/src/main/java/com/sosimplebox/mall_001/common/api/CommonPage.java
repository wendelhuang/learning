package com.sosimplebox.mall_001.common.api;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class CommonPage<T> {
	private Integer pageNum;
	private Integer pageSize;
	private Integer totalPage;
	private Long total;
	private List<T> list;
	
	public static <T> CommonPage<T> restPage(List<T> list) {
		CommonPage<T> result = new CommonPage<>();
		PageInfo<T> pageInfo = new PageInfo<>();
		result.setTotalPage(pageInfo.getPages());
		result.setPageNum(pageInfo.getPageNum());
		result.setPageSize(pageInfo.getPageSize());
		result.setTotal(pageInfo.getTotal());
		result.setList(pageInfo.getList());
		return result;
	}
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
