package com.mrl.spring.beans.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);

		// �ر�IOC����
		ctx.close();

		// ���� ��ʼ��bean���������� ��ʼ������ ����bean destroy����
		// Car's Constructor
		// setBrand
		// init...
		// Car [brand=Audi]
		// destroy

		// �����Զ���bean�ĺ��ô�����,���Զ�bean���д������
		// Car's Constructor
		// setBrand
		// postProcessBeforeInitialization��Car [brand=Audi],car
		// init...
		// postProcessAfterInitialization��Car [brand=Audi],car
		// Car [brand=Audi]
		// destroy

	}

}
