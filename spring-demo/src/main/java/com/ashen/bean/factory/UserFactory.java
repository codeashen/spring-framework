package com.ashen.bean.factory;

import com.ashen.bean.entity.User;

/**
 * 实例工厂调用
 */
public class UserFactory {
	/**
	 * 普通方法，返回 User 对象
	 * 不能通过类名调用，需要通过工厂对象调用
	 * @return
	 */
	public User getUser() {
		return new User();
	}
}
