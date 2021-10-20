package com.ashen.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 自定义事件发布器，实现 ApplicationEventPublisherAware 来设置事件发布器
 */
@Component
public class CustomEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher eventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}

	/**
	 * 调用事件发布器的发布事件方法
	 *
	 * @param event
	 */
	public void publishEvent(ApplicationEvent event) {
		eventPublisher.publishEvent(event);
	}
}
