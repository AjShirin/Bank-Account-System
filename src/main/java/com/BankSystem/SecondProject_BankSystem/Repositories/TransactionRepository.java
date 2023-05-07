package com.BankSystem.SecondProject_BankSystem.Repositories;


import com.BankSystem.SecondProject_BankSystem.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("SELECT t from Transaction t")
    List<Transaction> getAllTransaction();

    @Query("SELECT t from Transaction t where t.id= :transactionId")
    Transaction getTransactionById(@Param("transactionId") Integer id);

}
