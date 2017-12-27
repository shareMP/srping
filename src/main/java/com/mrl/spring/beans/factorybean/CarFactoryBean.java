package com.mrl.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author lwqMR
 *	自定义的FactoryBean 需要实现spring提供的FactoryBean
 */
public class CarFactoryBean implements FactoryBean<Car>{

	private String brand;
	
	
	
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public Car getObject() throws Exception {
		
		return new Car(brand,500000);
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}
	
}
