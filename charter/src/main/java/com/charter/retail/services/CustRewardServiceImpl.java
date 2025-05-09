package com.charter.retail.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.charter.retail.entites.CustomerInfo;

import com.charter.retail.entites.Reward;
import com.charter.retail.entites.Transaction;
import com.charter.retail.exceptions.BusinessException;
import com.charter.retail.repositories.CustomerInfoRepository;
import com.charter.retail.repositories.RewardRepository;
import com.charter.retail.repositories.TransactionRepository;

/**
 * @author dneelaka
 *
 */
/**
 * @author dneelaka
 *
 */
@Component(value="CustRewardService")
public class CustRewardServiceImpl implements CustRewardService{
	
	@Autowired
	private  RewardRepository rewardRepository ;
	
	@Autowired
	private  CustomerInfoRepository customerRepository;
	
	@Autowired
	 private TransactionRepository transactionRepository;

	/**
	 * 
	 * Calculates total reward points for a customer.
     * @param mobile Customer's mobile number
     * @param month Month of the rewards
     * @param year Year of the rewards
     * @return Total reward points

	 */
	@Override
	public int getCustomerRewardPoints(String mobile,int month,int year) throws BusinessException {
		CustomerInfo customerInfo = customerRepository.findByMobile(mobile);
		if(customerInfo==null) {
			throw new BusinessException("Customer does not exist for the given mobile number " + mobile);
		}
		List<Reward> rewardList = rewardRepository.findRewardsByCustomerAndMonth(mobile, month , year);
		if (rewardList!=null && !rewardList.isEmpty())
		{
			return rewardList.stream().mapToInt(Reward::getPoints).sum();
		}
		else {
			return 0;
		}
	}
	
    /**
     * @param transactionId
     * @return
     */
    public int calculateAndSaveRewardPoints(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        int points = calculateRewardPoints(transaction.getAmount());

        // Save reward record
        Reward reward = new Reward();
        reward.setTransaction(transaction);
        reward.setPoints(points);
        rewardRepository.save(reward);

        return points;
    }

    /**
     * @param amount
     * @return
     */
    private int calculateRewardPoints(Long amount) {
        int points = 0;

        if (amount > 100) {
            points += (amount - 100) * 2; // 2 points per dollar over 100
            amount = 100L;
        }
        if (amount > 50) {
            points += (amount - 50); // 1 point per dollar between 50 and 100
        }

        return points;
    }
	
	

	
}