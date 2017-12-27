package com.mrl.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {
	//Ҫ�������
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}
	
	/**���صĶ���
	 * @return
	 */
	public ArithmeticCalculator getLoggingPrxxy(){
		ArithmeticCalculator proxy = null;
		
		//�����������
		//loader,Ҫ���������������,����������Ǹ�����������м���
		ClassLoader loader = target.getClass().getClassLoader();
		// interfaces ������������  ����������Щ���� 
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};
		//h �����ô���������еķ���ʱ  ��ִ�еĴ���
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * proxy:���ڷ��صĴ������   ��invoke�в�ʹ��
			 * method :���ڱ����õķ���
			 * args:���÷���ʱ����Ĳ���
			 * */
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				System.out.println(proxy.toString()); ������ڴ���� ��ѭ��  proxy.toString()���������invoke....
				System.out.println("the method "+method.getName()+" begins with "+Arrays.asList(args));
				//ִ��
				Object res = method.invoke(target, args);
				System.out.println("the method "+method.getName()+" ends with "+res);
				return 0;
			}
		};
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
	
}
