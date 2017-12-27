package com.mrl.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author lwqMR
 *	bean�ĺ��ô�����
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization��"+bean+","+beanName);
		
		if("car".equals(beanName)){
			///���� ����
		}
		
		Car car = new Car();
		car.setBrand("����");
		//		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
		return car;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
	
		System.out.println("postProcessAfterInitialization��"+bean+","+beanName);
		return bean;
//		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
}
