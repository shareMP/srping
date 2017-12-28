package com.mrl.spring.jdbc.tx.exception;

public class AccountExeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountExeption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccountExeption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountExeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccountExeption(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
