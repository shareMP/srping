package com.mrl.spring.beans.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);

		// 关闭IOC容器
		ctx.close();

		// 过程 初始化bean，设置属性 初始化方法 返回bean destroy方法
		// Car's Constructor
		// setBrand
		// init...
		// Car [brand=Audi]
		// destroy

		// 加上自定义bean的后置处理器,可以对bean进行处理，检查
		// Car's Constructor
		// setBrand
		// postProcessBeforeInitialization：Car [brand=Audi],car
		// init...
		// postProcessAfterInitialization：Car [brand=Audi],car
		// Car [brand=Audi]
		// destroy

	}

}
