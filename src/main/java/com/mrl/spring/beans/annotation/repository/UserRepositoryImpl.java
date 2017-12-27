package com.mrl.spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrl.spring.beans.annotation.TestObject;

@Repository
public class UserRepositoryImpl implements UserRepository {

	//设置可以为null，不设置的话，如果没有对应的bean，会报错 
	@Autowired(required=false)
	private TestObject testObj;
	
	@Override
	public void save() {
		System.out.println(testObj);
		System.out.println("UserRepository...Save");
	}

}
