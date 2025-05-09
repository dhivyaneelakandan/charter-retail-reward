package com.charter.retail.services;

import com.charter.retail.exceptions.BusinessException;

public interface CustRewardService {
	public int getCustomerRewardPoints(String mobile, int month, int year) throws BusinessException;

	public int calculateAndSaveRewardPoints(Long transactionId);
}