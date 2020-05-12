package com.sosimplebox.p005_import.part2;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyClass implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(AccountDao.class);
		beanDefinitionRegistry.registerBeanDefinition("accountDaoRenamed", rootBeanDefinition);
	}
}
