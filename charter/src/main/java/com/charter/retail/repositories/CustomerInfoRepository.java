package com.charter.retail.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charter.retail.entites.CustomerInfo;
@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,Long>{


//	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM customer_info WHERE email = ?1", nativeQuery = true)
//	boolean existsByEmailNative(String email);	
//
//	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM customer_info WHERE id = ?1", nativeQuery = true)
//    boolean existsByIdNative(Long id);
//	
//	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM customer_info WHERE mobile = ?1", nativeQuery = true)
//    boolean existsByMobileNative(String mobile);
//	
	CustomerInfo findByMobile(String mobile);

}
