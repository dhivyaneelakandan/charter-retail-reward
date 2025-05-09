package com.charter.retail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.charter.retail.entites.CustomerInfo;
import com.charter.retail.entites.Reward;
import com.charter.retail.entites.Transaction;
import com.charter.retail.exceptions.BusinessException;
import com.charter.retail.repositories.CustomerInfoRepository;
import com.charter.retail.repositories.RewardRepository;
import com.charter.retail.services.CustRewardService;

@ExtendWith(MockitoExtension.class)
public class RewardServiceTest {

    @Mock
    private CustomerInfoRepository customerRepository;

    @Mock
    private RewardRepository rewardRepository;

    @InjectMocks
    private CustRewardService rewardService;

    @Test
    public void testCustomerNotFound_ThrowsException() {
        String mobile = "1234567890";
        when(customerRepository.findByMobile(mobile)).thenReturn(null);

        BusinessException exception = assertThrows(BusinessException.class, () ->
            rewardService.getCustomerRewardPoints(mobile, 5, 2025)
        );

        assertEquals("Customer does not exist for the given mobile number " + mobile, exception.getMessage());
    }

    @Test
    public void testCustomerFound_NoRewards_ReturnsZero() throws BusinessException {
        String mobile = "1234567890";
        CustomerInfo customer = new CustomerInfo();
        when(customerRepository.findByMobile(mobile)).thenReturn(customer);
        when(rewardRepository.findRewardsByCustomerAndMonth(mobile, 5, 2025)).thenReturn(Collections.emptyList());

        int points = rewardService.getCustomerRewardPoints(mobile, 5, 2025);
        assertEquals(0, points);
    }

    @Test
    public void testCustomerFound_WithRewards_ReturnsSum() throws BusinessException {
        String mobile = "1234567890";
        CustomerInfo customer = new CustomerInfo();
        List<Reward> rewards = Arrays.asList(new Reward(1L,110,new Transaction()), new Reward(2L,200,new Transaction()));

        when(customerRepository.findByMobile(mobile)).thenReturn(customer);
        when(rewardRepository.findRewardsByCustomerAndMonth(mobile, 5, 2025)).thenReturn(rewards);

        int points = rewardService.getCustomerRewardPoints(mobile, 5, 2025);
        assertEquals(30, points);
    }
}
