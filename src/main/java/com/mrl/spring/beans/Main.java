package com.mrl.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		// HelloWorld helloWorld = new HelloWorld();
		// helloWorld.setName("MRL");
		// helloWorld.hello();

		// spring方式 获取容器对象 获得bean 调用方法
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		helloWorld.hello();
		
		//要求只能有一个相同类型的bean的配置
		ctx.getBean(HelloWorld.class);
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		System.out.println(person);
	}
}
