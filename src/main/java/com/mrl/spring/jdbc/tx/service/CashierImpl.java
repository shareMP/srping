package com.mrl.spring.jdbc.tx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lwqMR
 *	Ω·’À µœ÷
 */
@Service("cashier")
public class CashierImpl implements Cashier{

	
	@Autowired
	private BookShopService bookShopService;
	
	@Transactional
	@Override
	public void checkout(String name, List<String> isbns) {
		for (String isbn : isbns) {
			bookShopService.purchase(name, isbn);
		}
	}

}
