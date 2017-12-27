package com.mrl.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
	
	//定义一个方法
	//声明切入点表达式,不需要加入其它的代码
	@Pointcut("execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public void declareJoinPointExpression(){}
	
	
	//声明前置通知
	@Before(value = "declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> params = Arrays.asList(joinPoint.getArgs()); 
		System.out.println("the method "+methodName+" begins with "+params);
	}
	
	//后置通知,在目标方法执行后执行的通知,无论是否发生异常
	//在后置通知中还不能访问目标方法执行的结果
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint point){
		String methodName = point.getSignature().getName();
		System.out.println("the method "+methodName+" end with ");
	}
	
	//返回通知,在方法正常结束后执行的代码
	//返回通知是可以访问到方法的返回值的
	//有异常不会返回
	@AfterReturning(value="execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method "+methodName+" ends with "+result);
	}
	
	//异常通知
	//在目标方法出现异常时，会执行的代码
	//可以访问到异常对象，可以指定在出现特定异常时执行.
	@AfterThrowing(value="execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method "+methodName+" occcurs "+ex.toString());
	}
	
	
	//环绕通知
	//环绕通知需要携带 ProceedingJoinPoint餐参数 
	//环绕通知类似于动态代理的全过程
	//ProceedingJoinPoint 可以决定是否执行目标方法
	//环绕通知必须有返回值，返回值即为目标方法的返回值
	@Around("execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public Object roundMessage(ProceedingJoinPoint point){
		
		Object res = null;
		String methdName = point.getSignature().getName();
		
		//执行目标方法
		try {
			//前置通知
			System.out.println("the method "+methdName+" begins with "+Arrays.asList(point.getArgs()));
			res = point.proceed();
			//返回通知
			System.out.println("the method "+methdName+" ends with "+res);
		} catch (Throwable e) {
			System.out.println("the method "+methdName+" occcurs "+e.toString());
			throw new RuntimeException(e);
		}
		
		//后置通知
		System.out.println("the method "+methdName+" ends");
		
		return  res;
	}
	
	
}
