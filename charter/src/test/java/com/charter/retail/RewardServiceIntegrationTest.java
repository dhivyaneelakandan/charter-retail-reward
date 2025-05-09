package com.charter.retail;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.charter.retail.entites.CustomerInfo;
import com.charter.retail.entites.Reward;
import com.charter.retail.entites.Transaction;
import com.charter.retail.exceptions.BusinessException;
import com.charter.retail.repositories.CustomerInfoRepository;
import com.charter.retail.repositories.RewardRepository;
import com.charter.retail.services.CustRewardService;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class RewardServiceIntegrationTest {

    @Autowired
    private CustRewardService rewardService;

    @Autowired
    private CustomerInfoRepository customerRepository;

    @Autowired
    private RewardRepository rewardRepository;

    @Test
    public void testGetCustomerRewardPoints_Integration() throws BusinessException {
        String mobile = "1234567890";
        CustomerInfo customer = new CustomerInfo();
        customer.setMobile(mobile);
        customerRepository.save(customer);

        Reward reward1 = new Reward(1L, 500, new Transaction());
        Reward reward2 = new Reward(2L, 5000, new Transaction());
        rewardRepository.saveAll(Arrays.asList(reward1, reward2));

        int points = rewardService.getCustomerRewardPoints(mobile, 5, 2025);
        assertEquals(40, points);
    }
}

