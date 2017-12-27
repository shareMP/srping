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
 *	��־����
 *	�ŵ�IOC������
 *	������Ϊһ������
 */
@Component
@Aspect
public class LoggingAspect {
	
	//����һ������
	//�����������ʽ,����Ҫ���������Ĵ���
	@Pointcut("execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public void declareJoinPointExpression(){}
	
	
	//����ǰ��֪ͨ
	@Before(value = "declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> params = Arrays.asList(joinPoint.getArgs()); 
		System.out.println("the method "+methodName+" begins with "+params);
	}
	
	//����֪ͨ,��Ŀ�귽��ִ�к�ִ�е�֪ͨ,�����Ƿ����쳣
	//�ں���֪ͨ�л����ܷ���Ŀ�귽��ִ�еĽ��
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint point){
		String methodName = point.getSignature().getName();
		System.out.println("the method "+methodName+" end with ");
	}
	
	//����֪ͨ,�ڷ�������������ִ�еĴ���
	//����֪ͨ�ǿ��Է��ʵ������ķ���ֵ��
	//���쳣���᷵��
	@AfterReturning(value="execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method "+methodName+" ends with "+result);
	}
	
	//�쳣֪ͨ
	//��Ŀ�귽�������쳣ʱ����ִ�еĴ���
	//���Է��ʵ��쳣���󣬿���ָ���ڳ����ض��쳣ʱִ��.
	@AfterThrowing(value="execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method "+methodName+" occcurs "+ex.toString());
	}
	
	
	//����֪ͨ
	//����֪ͨ��ҪЯ�� ProceedingJoinPoint�Ͳ��� 
	//����֪ͨ�����ڶ�̬�����ȫ����
	//ProceedingJoinPoint ���Ծ����Ƿ�ִ��Ŀ�귽��
	//����֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	@Around("execution(public int com.mrl.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public Object roundMessage(ProceedingJoinPoint point){
		
		Object res = null;
		String methdName = point.getSignature().getName();
		
		//ִ��Ŀ�귽��
		try {
			//ǰ��֪ͨ
			System.out.println("the method "+methdName+" begins with "+Arrays.asList(point.getArgs()));
			res = point.proceed();
			//����֪ͨ
			System.out.println("the method "+methdName+" ends with "+res);
		} catch (Throwable e) {
			System.out.println("the method "+methdName+" occcurs "+e.toString());
			throw new RuntimeException(e);
		}
		
		//����֪ͨ
		System.out.println("the method "+methdName+" ends");
		
		return  res;
	}
	
	
}
