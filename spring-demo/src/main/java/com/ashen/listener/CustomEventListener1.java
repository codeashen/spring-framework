package com.ashen.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 继承方式实现事件监听器
 */
@Component
public class CustomEventListener1 implements SmartApplicationListener {
	/**
	 * 事件回调方法
	 */
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("继承实现的监听器收到监听, event = " + ((CustomApplicationEvent) event).getEventName());
	}

	/**
	 * 判断本 Listener 是否关心该 ApplicationEvent
	 */
	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return CustomApplicationEvent.class.isAssignableFrom(eventType);
	}
}
