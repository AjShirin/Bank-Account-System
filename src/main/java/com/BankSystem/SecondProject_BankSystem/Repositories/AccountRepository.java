package com.BankSystem.SecondProject_BankSystem.Repositories;

import com.BankSystem.SecondProject_BankSystem.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("SELECT a from Account a")
    List<Account> getAllAccount();

    @Query("SELECT a from Account a where a.id= :accountId")
    Account getAccountById(@Param("accountId") Integer id);

    @Query(value = "Select a.balance From Account a WHERE a.id = :id")
    Double getBalanceForSpecificAccount(Integer id);

    @Query(value = "SELECT id FROM customer WHERE phone = :phone", nativeQuery = true)
    Integer findIdByPhoneNumber(@Param("phone") String phone);
}
