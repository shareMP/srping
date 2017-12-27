package com.mrl.spring.beans.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mrl.spring.beans.autowire.Adress;
import com.mrl.spring.beans.autowire.Person;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
		Adress adress = (Adress) ctx.getBean("adress");
		System.out.println(adress);
		
		
		Adress adress2 = (Adress) ctx.getBean("adress2");
		System.out.println(adress2);
		
		Person p = (Person) ctx.getBean("person");
		System.out.println(p);
	}

}
