package com.mrl.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author lwqMR
 *	日志切面
 *	放到IOC容器中
 *	再声明为一个切面
 */
@Component
@Aspect
public class LoggingAspect {
	
	//声明前置通知
	@Before(value = "execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> params = Arrays.asList(joinPoint.getArgs()); 
		System.out.println("the method "+methodName+" begins with "+params);
	}
	
	//后置通知,在目标方法执行后执行的通知,无论是否发生异常
	//在后置通知中还不能访问目标方法执行的结果
	@After("execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public void afterMethod(JoinPoint point){
		String methodName = point.getSignature().getName();
		System.out.println("the method "+methodName+" end with ");
	}
}
