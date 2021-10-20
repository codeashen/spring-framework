package com.ashen.bean.service.impl;

import com.ashen.bean.service.WelcomeService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("welcomeService")
@Lazy
public class WelcomeServiceImpl implements WelcomeService {
	@Override
	public void sayHello(String message) {
		System.out.println(message);
	}
}
