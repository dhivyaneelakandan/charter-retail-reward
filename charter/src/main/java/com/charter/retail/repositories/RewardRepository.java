package com.charter.retail.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.charter.retail.entites.Reward;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {

	    @Query("SELECT r FROM Reward r " +
	           "JOIN r.transaction t " +
	           "JOIN t.customer c " +
	           "WHERE c.mobile = :mobile " +
	           "AND FUNCTION('MONTH', t.transactionDate) = :month " +
	           "AND FUNCTION('YEAR', t.transactionDate) = :year")
	    List<Reward> findRewardsByCustomerAndMonth(
	        @Param("mobile") String mobile,
	        @Param("month") int month,
	        @Param("year") int year
	    );

		
}
