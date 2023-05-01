package com.BankSystem.SecondProject_BankSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
