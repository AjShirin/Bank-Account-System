package com.BankSystem.SecondProject_BankSystem.Services;

import com.BankSystem.SecondProject_BankSystem.Models.CreditCard;
import com.BankSystem.SecondProject_BankSystem.Models.Customer;
import com.BankSystem.SecondProject_BankSystem.Models.Loan;
import com.BankSystem.SecondProject_BankSystem.Repositories.CustomerRepository;
import com.BankSystem.SecondProject_BankSystem.Repositories.LoanRepository;
import com.BankSystem.SecondProject_BankSystem.RequestObject.LoanRequest;
import com.BankSystem.SecondProject_BankSystem.RequestObject.creditCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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
}
