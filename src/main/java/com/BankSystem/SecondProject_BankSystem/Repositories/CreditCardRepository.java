package com.BankSystem.SecondProject_BankSystem.Repositories;

import com.BankSystem.SecondProject_BankSystem.Models.CreditCard;
import com.BankSystem.SecondProject_BankSystem.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
    @Query("SELECT c from CreditCard c where c.id= :creditCard_Id")
    Customer getCreditCardById(@Param("creditCard_Id") Integer id);

    @Query("SELECT c from CreditCard c")
    List<CreditCard> getAllCreditCard();
}
