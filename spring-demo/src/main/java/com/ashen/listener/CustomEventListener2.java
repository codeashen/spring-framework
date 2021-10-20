package com.ashen.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 注解监听器
 */
@Component
public class CustomEventListener2 {
	/**
	 * 注解实现事件监听器
	 * @param event 监听器关心的事件
	 */
	@EventListener
	public void eventAction(CustomApplicationEvent event) {
		System.out.println("注解实现的监听器收到监听, event = " + event.getEventName());
	}
}
