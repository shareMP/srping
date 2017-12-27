package com.mrl.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwqMR
 * ֱ�ӵ���ĳһ����ľ�̬�����Ϳ��Է���bean��ʵ��
 */
public class StaticCarFactory {
	
	private static Map<String,Car> cars = new HashMap<>();
	
	static{
		cars.put("audi", new Car("Audi",300000));
		cars.put("audi", new Car("BMW",500000));
	}
	
	//��̬��������
	public static Car getCar(String name){
		return cars.get(name);
	}
}
