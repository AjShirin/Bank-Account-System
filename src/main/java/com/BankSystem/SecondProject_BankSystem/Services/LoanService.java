package com.BankSystem.SecondProject_BankSystem.Services;


import com.BankSystem.SecondProject_BankSystem.Models.Customer;
import com.BankSystem.SecondProject_BankSystem.Models.Loan;
import com.BankSystem.SecondProject_BankSystem.Repositories.CustomerRepository;
import com.BankSystem.SecondProject_BankSystem.Repositories.LoanRepository;
import com.BankSystem.SecondProject_BankSystem.RequestObject.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // function that creates a new loan record (createLoan)
    public void createLoan(LoanRequest loanRequest) {
        Loan loan = new Loan(); // create object
        loan.setAmount(loanRequest.getAmount());
        loan.setInterestRate(loanRequest.getInterestRate());
        loan.setUpdatedDate(new Date()); // give current date
        loan.setCreatedDate(new Date());// give current date
        loan.setIsActive(Boolean.TRUE);
        Customer customer = customerRepository.findById(loanRequest.getCustomerID()).get();
        loan.setCustomer(customer);
        loanRepository.save(loan);
    }

    //function that gets all Loan (getAllLoan)
    public List<Loan> getAllLoan() {
        return loanRepository.getAllLoan();
    }
    // Function that updates Loan (whole row) [updateLoan]
    public String updateLoan(LoanRequest loanRequest) {
        try {
            Loan loan = loanRepository.getLoanById(loanRequest.getId());
            loan.setAmount(loanRequest.getAmount());
            loan.setInterestRate(loanRequest.getInterestRate());
            loan.setUpdatedDate(new Date());
            loan.setIsActive(Boolean.TRUE);
            loanRepository.save(loan);
            return "The Account ID:" + loanRequest.getId() + " has been successfully updated :)";
        } catch (Exception e) {
            return "An error occurred, record is not updated. Please try again.";
        }
    }
    // function that makes the is active to false (deleteLoanById)
    public void deleteLoanById(LoanRequest loanRequest) {
        Loan loan = loanRepository.getLoanById(loanRequest.getId());
        loan.setIsActive(Boolean.FALSE);
        loanRepository.save(loan);
    }
}
