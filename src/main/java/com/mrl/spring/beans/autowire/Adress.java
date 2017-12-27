package com.mrl.spring.beans.autowire;

public class Adress {
	private String city;
	private String street;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Adress [city=" + city + ", street=" + street + "]";
	}
}
