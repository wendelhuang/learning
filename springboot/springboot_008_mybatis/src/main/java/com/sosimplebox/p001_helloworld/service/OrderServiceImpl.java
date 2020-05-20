package com.sosimplebox.p001_helloworld.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sosimplebox.p001_helloworld.dao.Order;
import com.sosimplebox.p001_helloworld.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
	
	/**
	 * 这里实际是一个变量， 达不到测试效果
	 */
	@Autowired
	private SqlSession sqlSession1;
	@Autowired
	private SqlSession sqlSession2;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	
	public void test() {
		realTestByFactory2();
	}
	public void testSqlSessionEqual() {
		System.out.println(sqlSession1.hashCode());
		System.out.println(sqlSession2.hashCode());
	}
	public void testSqlSessionEqualByFactory() {
		SqlSession sqlSession01 = sqlSessionFactory.openSession(false); 
		SqlSession sqlSession02 = sqlSessionFactory.openSession(false); 
		System.out.println(sqlSession01.hashCode());
		System.out.println(sqlSession02.hashCode());
	}
	public void testSqlSessionFactoryCacheConfiguration() {
		System.out.println(sqlSessionFactory.getConfiguration().getLocalCacheScope());
		System.out.println(sqlSessionFactory.getConfiguration().isCacheEnabled());
		System.out.println(sqlSessionFactory.openSession(true));
	}
	public void realTestByFactory1() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		System.out.println(orderMapper.listAllOrders());
		System.out.println(orderMapper.listAllOrders());
		System.out.println(orderMapper.listAllOrders());
	}
	
	public void realTestByFactory2() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		System.out.println(orderMapper.listAllOrders());
		Order newOrder = new Order(0, "2", new BigDecimal(2));
		int row = orderMapper.insertOrder(newOrder);
		System.out.println(row);
		System.out.println(orderMapper.listAllOrders());
		//sqlSession.close();
	}
	
	public void realTestByFactory3() {
		SqlSession sqlSession01 = sqlSessionFactory.openSession(true);
		SqlSession sqlSession02 = sqlSessionFactory.openSession(true);
		OrderMapper orderMapper01 = sqlSession01.getMapper(OrderMapper.class);
		OrderMapper orderMapper02 = sqlSession02.getMapper(OrderMapper.class);
		
		List<Order> list = orderMapper01.listAllOrders();
		System.out.println(list);
		list = orderMapper01.listAllOrders();
		System.out.println(list);
		
		Order newOrder = new Order(list.get(0).getId(), "aaa", list.get(0).getMoney());
		orderMapper02.updateOrder(newOrder);
		System.out.println(orderMapper01.listAllOrders());
		System.out.println(orderMapper02.listAllOrders());
	}
	
	public void realTest1() {
		OrderMapper orderMapper1 = sqlSession1.getMapper(OrderMapper.class);
		System.out.println(orderMapper1.listAllOrders());
		System.out.println(orderMapper1.listAllOrders());
		System.out.println(orderMapper1.listAllOrders());
	}
	
	public void realTest2() {
		OrderMapper orderMapper1 = sqlSession1.getMapper(OrderMapper.class);
		List<Order> list = orderMapper1.listAllOrders();
		System.out.println(list);
		Order oldOrder = list.get(0);
		Order newOrder = new Order(oldOrder.getId(), "new name", oldOrder.getMoney());
		orderMapper1.updateOrder(newOrder);
		list = orderMapper1.listAllOrders();
		System.out.println(list);
	}
	
	
	public void realTest3() {
		OrderMapper orderMapper1 = sqlSession1.getMapper(OrderMapper.class);
		OrderMapper orderMapper2 = sqlSession2.getMapper(OrderMapper.class);
		
		System.out.println("------------------1--------------------");
		List<Order> list = orderMapper1.listAllOrders();
		list = orderMapper1.listAllOrders();
		
		System.out.println("------------------2--------------------");
		Order oldOrder = list.get(0);
		Order newOrder = new Order(oldOrder.getId(), "new name", oldOrder.getMoney());
		orderMapper2.updateOrder(newOrder);
		
		System.out.println("------------------3--------------------");
		System.out.println(orderMapper1.listAllOrders());
		System.out.println("------------------4--------------------");
		System.out.println(orderMapper2.listAllOrders());
	}
	
	public List<Order> listAllOrders() {
		List<Order> r = orderMapper.listAllOrders();
		r = orderMapper.listAllOrders();
		r = orderMapper.listAllOrders();
		return orderMapper.listAllOrders();
	}
	
	public void showAllOrders() {
		OrderMapper orderMapper1 = sqlSession1.getMapper(OrderMapper.class);
		OrderMapper orderMapper2 = sqlSession1.getMapper(OrderMapper.class);
		
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
