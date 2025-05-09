package com.charter.retail.exceptions;

public class BusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3437272194969154975L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
		
	}

}
