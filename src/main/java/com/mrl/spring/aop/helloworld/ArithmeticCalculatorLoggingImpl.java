package com.mrl.spring.aop.helloworld;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		System.out.println("the method add begins with ["+i+","+j+"]");
		int res = i + j;
		System.out.println("the method add ends with "+res);
		return res;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("the method sub begins with ["+i+","+j+"]");
		int res = i - j;
		System.out.println("the method sub ends with "+res);
		return res;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("the method mul begins with ["+i+","+j+"]");
		int res = i * j;
		System.out.println("the method mul ends with "+res);
		return res;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("the method div begins with ["+i+","+j+"]");
		int res = i / j;
		System.out.println("the method div ends with "+res);
		return res;
	}

}
