package com.mrl.spring.jdbc.tx.service;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BookShopServiceTest {

	private ApplicationContext ctx = null;
	BookShopService service = null;
	private Cashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("tx/springContext.xml");
		service = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	
	@Test
	public void testPurchase() {
		service.purchase("小明", "1001");
	}
	
	@Test
	public void testTransactionPropagation(){
		cashier.checkout("小明", Arrays.asList("1001","1002"));
	}

}
