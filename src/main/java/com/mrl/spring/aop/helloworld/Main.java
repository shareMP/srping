package com.mrl.spring.aop.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
//		ArithmeticCalculator arithmeticCalculator = null;
//		arithmeticCalculator = new ArithmeticCalculatorImpl();
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop-test.xml");
//		
//		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
//		
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingPrxxy();
		
		
		int res = proxy.add(2, 3);
		System.out.println(res);
		
		int res2 = proxy.div(4, 2);
		System.out.println(res2);
	}
}
