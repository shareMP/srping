package com.mrl.spring.beans;

import java.util.Date;

/**
 * @author lwq
 * person实体
 */
public class Person {
	
	private String name;
	private String gender;
	private Date birthday;
	
	private Car car;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", car=" + car + "]";
	}
	public Person(String name, String gender, Car car) {
		super();
		this.name = name;
		this.gender = gender;
		this.car = car;
	}
	public Person() {
		super();
	}
	
	
	
}
