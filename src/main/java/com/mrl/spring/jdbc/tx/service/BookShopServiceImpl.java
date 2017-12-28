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
	
	//1.�������ע��
	//ʹ��propagationָ������Ĵ�����Ϊ
	//��ǰ���񷽷�����һ�����񷽷����õ�ʱ�����ʹ������
	//��������һ���������������¿�һ������
	//Ĭ��ȡֵΪ   REQUIRED  ʹ�õ��÷���������
	//��������ȡֵ��:REQUIRES_NEW �¿�һ������	 ���õ����񷽷������񱻹���
	
	//2.����ĸ��뼶��
	//isolationָ��
	//READ_COMMITTED:�����ύ
	
	//3.Ĭ�������spring������ʽ��������е�����ʱ�쳣���лع�,Ҳ����ͨ����Ӧ�����Խ�������
	//noRollbackFor ����Щ�쳣�����лع�,ͨ�������ȡĬ��ֵ	
//	@Transactional(propagation=Propagation.REQUIRES_NEW,
//			isolation=Isolation.READ_COMMITTED,
//			noRollbackFor={AccountExeption.class})
	
	//4.ʹ��readonlyָ�������Ƿ���ֻ��
	//readOnly=true ���԰������ݿ�����Բ�ѯ�����Ż�
	//���ֻ�Ƕ�ȡ���ݿ�ķ�����Ӧ������readonly=true
	
	//5.timeout ʹ��timeout ָ��ǿ�ƻع�֮ǰ�������ռ�õ�ʱ��
	//���Լ�������ռ�����ӵ�ʱ��  ���ռ��ʱ��̫����ǿ�ƻع��������
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
		
		//��ȡ��ĵ���
		Double price = bookShopDao.findBookPriceByIsbn(isbn);

		
		//������Ŀ��
		bookShopDao.updateBookStock(isbn);
		//�����û����
		bookShopDao.updateUserAccount(name, price);
		
	}

}
