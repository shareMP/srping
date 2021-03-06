package com.mrl.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwqMR
 * 直接调用某一个类的静态方法就可以返回bean的实例
 */
public class StaticCarFactory {
	
	private static Map<String,Car> cars = new HashMap<>();
	
	static{
		cars.put("audi", new Car("Audi",300000));
		cars.put("audi", new Car("BMW",500000));
	}
	
	//静态工厂方法
	public static Car getCar(String name){
		return cars.get(name);
	}
}
