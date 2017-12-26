package com.mrl.spring.beans.collection;

import java.util.Date;
import java.util.Map;

import com.mrl.spring.beans.Car;

/**
 * @author lwq
 * NewPerson实体
 */
public class NewPerson {
	
	private String name;
	private String gender;
	private Date birthday;
	
	
	private Map<String,Car> cars;
	
	public Map<String, Car> getCars() {
		return cars;
	}
	public void setCars(Map<String, Car> cars) {
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
		return "NewPerson [name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", cars=" + cars + "]";
	}
	
}
