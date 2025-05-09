package com.charter.retail.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.charter.retail.exceptions.BusinessException;

@ControllerAdvice
public class GloablHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleProductDetailsNotFoundException(BusinessException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
