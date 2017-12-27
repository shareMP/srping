package com.mrl.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {
	//要代理对象
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}
	
	/**返回的对象
	 * @return
	 */
	public ArithmeticCalculator getLoggingPrxxy(){
		ArithmeticCalculator proxy = null;
		
		//创建代理对象
		//loader,要代理对象的类加载器,代理对象由那个类加载器进行加载
		ClassLoader loader = target.getClass().getClassLoader();
		// interfaces 代理对象的类型  即其中有哪些方法 
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};
		//h 当调用代理对象其中的方法时  该执行的代码
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * proxy:正在返回的代理对象   在invoke中不使用
			 * method :正在被调用的方法
			 * args:调用方法时传入的参数
			 * */
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				System.out.println(proxy.toString()); 这里会内存溢出 死循环  proxy.toString()会继续调用invoke....
				System.out.println("the method "+method.getName()+" begins with "+Arrays.asList(args));
				//执行
				Object res = method.invoke(target, args);
				System.out.println("the method "+method.getName()+" ends with "+res);
				return 0;
			}
		};
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
	
}
