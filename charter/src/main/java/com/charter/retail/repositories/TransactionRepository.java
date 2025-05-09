package com.charter.retail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charter.retail.entites.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
