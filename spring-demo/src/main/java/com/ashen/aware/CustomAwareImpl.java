package com.ashen.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 实现 Aware 接口的 Bean, 
 * 重写 XxxAware 接口的 setXxx() 方法, 将属性设置到 Bean 中
 */
@Component
public class CustomAwareImpl implements BeanNameAware, ApplicationContextAware {
	
	private String myName;
	private ApplicationContext applicationContext;
	
	public void hello() {
		System.out.println("我是各种 Aware 接口的实现类，myName = " + myName);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames));
	}
	
	@Override
	public void setBeanName(String name) {
		this.myName = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
