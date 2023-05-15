package com.BankSystem.SecondProject_BankSystem.Repositories;

import com.BankSystem.SecondProject_BankSystem.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    @Query("SELECT l from Loan l") // the name 'Loan' should be same as the models
    List<Loan> getAllLoan();

    @Query("SELECT l from Loan l where l.id= :loanId")
    Loan getLoanById(@Param("loanId") Integer id);


    @Query ("SELECT l.isActive from Loan l where l.customer.id= :customerId")
    Boolean getLoanActivationByCustomerId(@Param("customerId") Integer id);
}
