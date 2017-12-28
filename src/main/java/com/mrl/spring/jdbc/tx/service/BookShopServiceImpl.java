package com.mrl.spring.jdbc.tx.service;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mrl.spring.jdbc.tx.dao.BookShopDao;
import com.mrl.spring.jdbc.tx.exception.AccountExeption;

@Service
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	
	//1.添加事务注解
	//使用propagation指定事务的传播行为
	//当前事务方法被另一个事务方法调用的时候，如何使用事务
	//是用另外一个方法的事务还是新开一个事务？
	//默认取值为   REQUIRED  使用调用方法的事务
	//其他几种取值是:REQUIRES_NEW 新开一个事务	 调用的事务方法的事务被挂起
	
	//2.事务的隔离级别：
	//isolation指定
	//READ_COMMITTED:读已提交
	
	//3.默认情况：spring的声明式事务对所有的运行时异常进行回滚,也可以通过对应的属性进行设置
	//noRollbackFor 对哪些异常不进行回滚,通常情况下取默认值	
//	@Transactional(propagation=Propagation.REQUIRES_NEW,
//			isolation=Isolation.READ_COMMITTED,
//			noRollbackFor={AccountExeption.class})
	
	//4.使用readonly指定事务是否是只读
	//readOnly=true 可以帮助数据库引擎对查询就行优化
	//如果只是读取数据库的方法，应该设置readonly=true
	
	//5.timeout 使用timeout 指定强制回滚之前事务可以占用的时间
	//可以减少事务占用连接的时间  如果占用时间太长，强制回滚这个事务
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED,timeout=3
			)
	@Override
	public void purchase(String name, String isbn) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取书的单价
		Double price = bookShopDao.findBookPriceByIsbn(isbn);

		
		//更新书的库存
		bookShopDao.updateBookStock(isbn);
		//更新用户余额
		bookShopDao.updateUserAccount(name, price);
		
	}

}
