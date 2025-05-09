package com.charter.retail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charter.retail.exceptions.BusinessException;
import com.charter.retail.services.CustRewardService;

@RestController
public class CustomerController {

	@Autowired CustRewardService service ;
	@GetMapping (value = "/getCustomerRewards")
	public ResponseEntity<Integer> getCustomerRewards(@RequestParam String mobile,
			@RequestParam int month,
			@RequestParam int year) throws BusinessException{		
		return new ResponseEntity<>(service.getCustomerRewardPoints(mobile, month, year),HttpStatus.OK);
	}

	

}