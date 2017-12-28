package com.mrl.spring.jdbc.tx.dao;

import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mrl.spring.jdbc.tx.beans.Book;

public class BookShopDaoTest {

	private ApplicationContext ctx = null;
	BookShopDao dao = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("tx/springContext.xml");
		dao = ctx.getBean(BookShopDao.class);
	}
	
	
	@Test
	public void testFindBookPriceByIsbn() {
		System.out.println(dao.findBookPriceByIsbn("1001"));
	}

	@Test
	public void testUpdateBookStock() {
		dao.updateBookStock("1001");
	}

	@Test
	public void testUpdateUserAccount() {
		dao.updateUserAccount("Ð¡Ã÷", 2900.00);
	}

	@Test
	public void testInsetABook(){
		Book book = new Book();
		book.setId(UUID.randomUUID().toString());
		book.setBookname("³ÁË¼Â¼");
		book.setIsbn("1002");
		book.setPrice(50.00);
		
		dao.insertBook(book);
		
	}
	
}
