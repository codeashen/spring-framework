package com.ashen.postprocessor;

import com.ashen.bean.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义 BeanDefinitionRegistryPostProcessor 实现。
 * 在 BeanFactoryPostProcessor 之前调用，可以继续注册 BeanDefinition。
 */
@Configuration
public class CustomBeanDefinitionRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor {
	/**
	 * 向容器中继续注册 BeanDefinition，
	 * 实际生产中可以用于搜索第三方 Class，注册到 Spring 容器中，
	 * MyBatis 整合 Spring 就有这么用。
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		Class<User> clazz = User.class;
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
		GenericBeanDefinition definition = (GenericBeanDefinition) builder.getBeanDefinition();
		registry.registerBeanDefinition("user5", definition);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
	}
}
