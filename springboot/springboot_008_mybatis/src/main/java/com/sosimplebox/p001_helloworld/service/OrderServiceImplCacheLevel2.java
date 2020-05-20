package com.sosimplebox.p001_helloworld.service;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sosimplebox.p001_helloworld.dao.Order;
import com.sosimplebox.p001_helloworld.mapper.OrderMapper;
import com.sosimplebox.p001_helloworld.mapper.OrderMapperCacheLevel2;

@Service
public class OrderServiceImplCacheLevel2 implements OrderServiceCacheLevel2{

	@Autowired
	private OrderMapperCacheLevel2 orderMapper;
	
	@Autowired
	private SqlSession sqlSession0001;
	@Autowired
	private SqlSession sqlSession0002;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	
	public void test() {
		realTest2();
	}
	
	public void testSqlSessionFactoryCacheConfiguration() {
		System.out.println(sqlSessionFactory.getConfiguration().getLocalCacheScope());
		System.out.println(sqlSessionFactory.getConfiguration().isCacheEnabled());
		System.out.println(sqlSessionFactory.openSession(true));
	}
	
	public void realTest1() {
		SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
		SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
		OrderMapperCacheLevel2 orderMapperCacheLevel1 = sqlSession1.getMapper(OrderMapperCacheLevel2.class);
		OrderMapperCacheLevel2 orderMapperCacheLevel2 = sqlSession2.getMapper(OrderMapperCacheLevel2.class);
		System.out.println(orderMapperCacheLevel1.listAllOrders());
		System.out.println(orderMapperCacheLevel2.listAllOrders());
	}
	
	public void realTest2() {
		SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
		SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
		OrderMapperCacheLevel2 orderMapperCacheLevel1 = sqlSession1.getMapper(OrderMapperCacheLevel2.class);
		OrderMapperCacheLevel2 orderMapperCacheLevel2 = sqlSession2.getMapper(OrderMapperCacheLevel2.class);
		System.out.println(orderMapperCacheLevel1.listAllOrders());
		sqlSession1.commit();
		System.out.println(orderMapperCacheLevel2.listAllOrders());
	}
	
	
	public void realTest3() {
		SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
		SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
		SqlSession sqlSession3 = sqlSessionFactory.openSession(true);
		OrderMapperCacheLevel2 orderMapperCacheLevel1 = sqlSession1.getMapper(OrderMapperCacheLevel2.class);
		OrderMapperCacheLevel2 orderMapperCacheLevel2 = sqlSession2.getMapper(OrderMapperCacheLevel2.class);
		OrderMapperCacheLevel2 orderMapperCacheLevel3 = sqlSession3.getMapper(OrderMapperCacheLevel2.class);
		
		List<Order> list = orderMapperCacheLevel1.listAllOrders();
		System.out.println(list);
		sqlSession1.commit();
		list = orderMapperCacheLevel2.listAllOrders();
		System.out.println(list);
		
		Order newOrder = new Order(list.get(0).getId(), "aaaaa", list.get(0).getMoney());
		orderMapperCacheLevel3.updateOrder(newOrder);
		sqlSession3.commit();
		list = orderMapperCacheLevel2.listAllOrders();
		System.out.println(list);
	}
	
	public List<Order> listAllOrders() {
		List<Order> r = orderMapper.listAllOrders();
		r = orderMapper.listAllOrders();
		r = orderMapper.listAllOrders();
		return orderMapper.listAllOrders();
	}
	
	public void showAllOrders() {
		OrderMapper orderMapper1 = sqlSession0001.getMapper(OrderMapper.class);
		OrderMapper orderMapper2 = sqlSession0001.getMapper(OrderMapper.class);
		
		System.out.println("------------------1--------------------");
		orderMapper1.listAllOrders();
		System.out.println("------------------2--------------------");
		orderMapper2.listAllOrders();
		
		System.out.println("------------------1--------------------");
		orderMapper1.listAllOrders();
		System.out.println("------------------2--------------------");
		orderMapper2.listAllOrders();
	}

}
