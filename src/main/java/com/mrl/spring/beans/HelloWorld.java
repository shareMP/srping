package com.mrl.spring.beans;

public class HelloWorld
{
    private String name;
    
    private Person person;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPerson(Person person){
    	this.person = person;
    }
    
    public void hello(){
        System.out.println("hello:"+name);
    }
    
    public void helloTo(){
    	System.out.println("hello:::"+person.getName()+"gender:"+person.getGender());
    }

	public HelloWorld() {
		System.out.println("Constror...");
	}
    
    
}
