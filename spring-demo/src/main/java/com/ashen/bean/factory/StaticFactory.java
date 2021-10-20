package com.ashen.bean.factory;

import com.ashen.bean.entity.User;

/**
 * 静态工厂调用
 */
public class StaticFactory {
	/**
	 * 静态方法，返回 User 对象
	 * @return
	 */
	public static User getUser() {
		return new User();
	}
}
