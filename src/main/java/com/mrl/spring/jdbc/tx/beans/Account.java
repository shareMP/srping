package com.mrl.spring.jdbc.tx.beans;

/**
 * @author lwqMR
 *	个人账户类
 */
public class Account {
	private String id;
	private String name;
	private Double balacne;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalacne() {
		return balacne;
	}
	public void setBalacne(Double balacne) {
		this.balacne = balacne;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balacne=" + balacne + "]";
	}
	
}
