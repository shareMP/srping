package com.mrl.spring.beans.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mrl.spring.beans.annotation.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired  
	@Qualifier("userRepositoryImpl")  //指定装配的实现类
	private UserRepository userRepository;
	
	public void add(){
		System.out.println("UserService...Add");
		userRepository.save();
	}
}
