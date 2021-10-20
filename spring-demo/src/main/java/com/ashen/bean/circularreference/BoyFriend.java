package com.ashen.bean.circularreference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoyFriend {
	@Autowired
	private GirlFriend girlFriend;
}
