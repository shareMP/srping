package com.mrl.spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrl.spring.beans.annotation.TestObject;

@Repository
public class UserRepositoryImpl implements UserRepository {

	//���ÿ���Ϊnull�������õĻ������û�ж�Ӧ��bean���ᱨ�� 
	@Autowired(required=false)
	private TestObject testObj;
	
	@Override
	public void save() {
		System.out.println(testObj);
		System.out.println("UserRepository...Save");
	}

}
