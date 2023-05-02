package com.BankSystem.SecondProject_BankSystem.Repositories;


import com.BankSystem.SecondProject_BankSystem.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
