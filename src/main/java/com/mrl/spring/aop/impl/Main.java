package com.mrl.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/applicationContext.xml");
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		int res = arithmeticCalculator.add(1, 2);
		
		int res2 = arithmeticCalculator.div(4, 2);
		System.out.println(res2);
		
		
	}

}
