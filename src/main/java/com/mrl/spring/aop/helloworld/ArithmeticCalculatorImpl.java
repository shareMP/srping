package com.mrl.spring.aop.helloworld;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		int res = i + j;
		return res;
	}

	@Override
	public int sub(int i, int j) {
		int res = i - j;
		return res;
	}

	@Override
	public int mul(int i, int j) {
		int res = i * j;
		return res;
	}

	@Override
	public int div(int i, int j) {
		int res = i / j;
		return res;
	}

}
