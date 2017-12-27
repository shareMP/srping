package com.mrl.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwqMR
 *ʵ������  ����Ҫ�������������ٵ��ù�����ʵ������
 */
public class InstanceCarFactory {
	
	private Map<String,Car> cars  = null;

	public InstanceCarFactory() {
		cars = new HashMap<>();
		cars.put("audi", new Car("Audi",300000));
		cars.put("bmw", new Car("BMW",500000));
	}
	
	/**
	 * ʵ�������ķ���
	 * @param brand
	 * @return
	 */
	public Car getCar(String brand){
		return cars.get(brand);
	}
}
