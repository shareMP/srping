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
 *	��־����
 *	�ŵ�IOC������
 *	������Ϊһ������
 */
@Component
@Aspect
public class LoggingAspect {
	
	//����ǰ��֪ͨ
	@Before(value = "execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> params = Arrays.asList(joinPoint.getArgs()); 
		System.out.println("the method "+methodName+" begins with "+params);
	}
	
	//����֪ͨ,��Ŀ�귽��ִ�к�ִ�е�֪ͨ,�����Ƿ����쳣
	//�ں���֪ͨ�л����ܷ���Ŀ�귽��ִ�еĽ��
	@After("execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public void afterMethod(JoinPoint point){
		String methodName = point.getSignature().getName();
		System.out.println("the method "+methodName+" end with ");
	}
}
