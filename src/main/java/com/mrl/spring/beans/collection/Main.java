package com.mrl.spring.beans.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Person person = (Person) ctx.getBean("person5");
		System.out.println(person);
		
		NewPerson person2 = (NewPerson) ctx.getBean("newperson");
		System.out.println(person2);
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
	}

}
