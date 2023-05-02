package com.BankSystem.SecondProject_BankSystem.Services;

import com.BankSystem.SecondProject_BankSystem.Models.Loan;
import com.BankSystem.SecondProject_BankSystem.Repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    // function to create a new loan application of a customer
    public void createLoan(Double amount, Double intredtRate) {
        Loan loan = new Loan(); // create object
        loan.setAmount(amount);
        loan.setInterestRate(intredtRate);
        loan.setCreatedDate(new Date()); // give current date
        loan.setUpdatedDate(new Date()); // give current date
        loan.setIsActive(Boolean.TRUE);
        loanRepository.save(loan);
    }
}
