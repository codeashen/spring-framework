package com.ashen.listener;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 */
@SuppressWarnings("serial")
public class CustomApplicationEvent extends ApplicationEvent {
	private String eventName;
	
	public CustomApplicationEvent(Object source, String eventName) {
		super(source);
		this.eventName = eventName;
	}
	
	public String getEventName() {
		return this.eventName;
	}
}
