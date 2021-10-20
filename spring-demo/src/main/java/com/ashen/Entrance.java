package com.ashen;

import com.ashen.aware.CustomAwareImpl;
import com.ashen.bean.entity.User;
import com.ashen.bean.factory.UserFactoryBean;
import com.ashen.bean.service.WelcomeService;
import com.ashen.listener.CustomApplicationEvent;
import com.ashen.listener.CustomEventPublisher;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan("com.ashen")
public class Entrance {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Entrance.class);
		
		System.out.println("---------------- 获取 Bean 定义 ----------------");
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

		System.out.println("---------------- 获取 Bean 实例 ----------------");
		// 获取 BeanDefinitionRegistryPostProcessor 注册的 Bean 实例
		User user5 = (User) context.getBean("user5");
		System.out.println("BeanDefinitionRegistryPostProcessor 注册的 Bean: " + user5);
		// 获取 lazy-load 的 Bean
		WelcomeService welcomeService = context.getBean(WelcomeService.class);
		welcomeService.sayHello("Hello, Spring 框架!");

		System.out.println("-------------- 获取 Aware 的 Bean --------------");
		// 获取实现 Aware 接口的 Bean
		CustomAwareImpl customAwareImpl = context.getBean(CustomAwareImpl.class);
		customAwareImpl.hello();

		System.out.println("------------------- 发布事件 -------------------");
		// 获取事件发布器并发布事件
		CustomEventPublisher publisher = context.getBean(CustomEventPublisher.class);
		publisher.publishEvent(new CustomApplicationEvent(publisher, "事件1"));
	}

	public static void main2(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		WelcomeService welcomeService = (WelcomeService) context.getBean("welcomeService");
		welcomeService.sayHello("Hello，强大的 Spring 框架!");

		// 无参构造创建的对象
		User user1a = (User) context.getBean("user1");
		User user1b = (User) context.getBean("user1");
		// 静态工厂创建的对象
		User user2a = (User) context.getBean("user2");
		User user2b = (User) context.getBean("user2");
		// 实例工厂创建的对象
		User user3a = (User) context.getBean("user3");
		User user3b = (User) context.getBean("user3");
		// FactoryBean 创建的对象
		User user4a = (User) context.getBean("userFactoryBean");
		// 获取 FactoryBean 自身
		UserFactoryBean userFactoryBean = (UserFactoryBean) context.getBean(BeanFactory.FACTORY_BEAN_PREFIX + "userFactoryBean");

		System.out.println("无参构造创建的对象: " + user1a);
		System.out.println("无参构造创建的对象: " + user1b);
		System.out.println("静态工厂创建的对象: " + user2a);
		System.out.println("静态工厂创建的对象: " + user2b);
		System.out.println("实例工厂创建的对象: " + user3a);
		System.out.println("实例工厂创建的对象: " + user3b);
		System.out.println("FactoryBean 创建的对象: " + user4a);
		System.out.println("获取 FactoryBean 自身: " + userFactoryBean);
	}
}
