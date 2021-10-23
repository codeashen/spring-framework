package com.ashen.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
	@Pointcut("execution(* com.ashen.bean.service..*.*(..))")
	public void embed(){}

	@Before("embed()")
	public void before(JoinPoint joinPoint) {
		System.out.println("开始调用" + joinPoint);
	}
	
	@After("embed()")
	public void after(JoinPoint joinPoint) {
		System.out.println("调用完成" + joinPoint);
	}

	@Around("embed()")
	public Object around(ProceedingJoinPoint pjp) {
		long startTime = System.currentTimeMillis();
		Object ret = null;
		System.out.println("开始计时" + pjp);
		try {
			ret = pjp.proceed();
			System.out.println("执行成功，结束计时" + pjp);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			System.out.println("执行失败，结束计时" + pjp);
		} finally {
			long endTime = System.currentTimeMillis();
			System.out.println("总耗时 " + pjp + "[" + (endTime - startTime) + "]ms");
		}
		return ret;
	}

	@AfterReturning(pointcut = "embed()", returning = "ret")
	public void afterReturning(JoinPoint joinPoint, Object ret) {
		System.out.println("无论是空还是有值都返回" + joinPoint + ", 返回值[" + ret + "]");
	}

	@AfterThrowing(pointcut = "embed()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		System.out.println("抛出异常通知" + joinPoint + " " + exception.getMessage());
	}
}
