package com.mrl.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwqMR
 *实例工厂  先需要创建工厂本身再调用工厂的实例方法
 */
public class InstanceCarFactory {
	
	private Map<String,Car> cars  = null;

	public InstanceCarFactory() {
		cars = new HashMap<>();
		cars.put("audi", new Car("Audi",300000));
		cars.put("bmw", new Car("BMW",500000));
	}
	
	/**
	 * 实例工厂的方法
	 * @param brand
	 * @return
	 */
	public Car getCar(String brand){
		return cars.get(brand);
	}
}
