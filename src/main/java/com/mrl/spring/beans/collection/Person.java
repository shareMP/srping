package com.mrl.spring.beans.collection;

import java.util.Date;
import java.util.List;

import com.mrl.spring.beans.Car;

/**
 * @author lwq
 * person实体
 */
public class Person {
	
	private String name;
	private String gender;
	private Date birthday;
	
	
	private List<Car> cars;
	

	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
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
		return "Person [name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", cars=" + cars + "]";
	}
	
	
}
