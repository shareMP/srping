package com.mrl.spring.beans.annotation.controlor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mrl.spring.beans.annotation.service.UserService;

@Controller
public class UserControlor {
	
	@Autowired
	private UserService service;
	
	public void execute(){
		System.out.println("UserControlor...execute");
		service.add();
	}
}
