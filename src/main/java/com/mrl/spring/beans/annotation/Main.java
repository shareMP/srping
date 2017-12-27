package com.mrl.spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mrl.spring.beans.annotation.controlor.UserControlor;
import com.mrl.spring.beans.annotation.repository.UserRepository;
import com.mrl.spring.beans.annotation.service.UserService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
		TestObject to = (TestObject) ctx.getBean("testObject");
		System.out.println(to);
		
		UserControlor controlor  =  (UserControlor) ctx.getBean("userControlor");
		System.out.println(controlor);
	
		UserRepository repository = (UserRepository) ctx.getBean("userRepository");
		System.out.println(repository);
		
		UserService service =  (UserService) ctx.getBean("userService");
		System.out.println(service);
		
	}

}
