package com.mrl.spring.jdbc.tx.service;

import java.util.List;

/**
 * @author lwqMR
 *  ����
 */
public interface Cashier {
	public void checkout(String name,List<String> isbns);
}
