package com.mrl.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[] args) {
        
       
//        HelloWorld helloWorld = new HelloWorld();
//        helloWorld.setName("MRL");
//        helloWorld.hello();
        
        //spring方式
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = (HelloWorld) app.getBean("helloWorld");
        helloWorld.hello();
    }
}
