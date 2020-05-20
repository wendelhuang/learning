package com.sosimplebox.p001_factorybean.engine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;

import com.sosimplebox.p001_factorybean.exception.NoSpiChooseException;

public class SpiFactoryBean<T> implements FactoryBean<T> {
	private Class<? extends ISpi> spiClz;
	
	private List<ISpi<T>> list;
	
	public SpiFactoryBean(ApplicationContext applicationContext, Class<? extends ISpi> clz) {
		this.spiClz = clz;
		Map<String, ? extends ISpi> map = applicationContext.getBeansOfType(spiClz);
		list = new ArrayList<>(map.values());
		list.sort(Comparator.comparingInt(ISpi::order));
	}

	@Override
	public T getObject() throws Exception {
		InvocationHandler invocationHandler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				for (ISpi spi : list) {
					if (spi.verify(args[0])) {
						return method.invoke(spi, args);
					}
				}
				throw new NoSpiChooseException("no spi server can execute! spiList: " + list);
			}
		};
		return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] {spiClz}, invocationHandler);
	}

	@Override
	public Class<?> getObjectType() {
		return spiClz;
	}

}
