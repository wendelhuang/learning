package com.sosimplebox.p001_helloworld.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sosimplebox.p001_helloworld.dao.Order;

@Mapper
public interface OrderMapper {
	@Select("select * from `order`")
	List<Order> listAllOrders();
	
	@Update("update `order` set name = #{name} where id = #{id}")
	int updateOrder(Order order);
	
	@Insert("insert into `order` (name, money) values (#{name}, #{money})")
	int insertOrder(Order order);
}
