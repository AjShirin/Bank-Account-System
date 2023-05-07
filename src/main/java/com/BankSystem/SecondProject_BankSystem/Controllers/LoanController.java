package com.BankSystem.SecondProject_BankSystem.Controllers;

import com.BankSystem.SecondProject_BankSystem.Models.Loan;
import com.BankSystem.SecondProject_BankSystem.RequestObject.LoanRequest;
import com.BankSystem.SecondProject_BankSystem.Services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "loan")
public class LoanController {

    @Autowired
    LoanService loanService;

    // function that creates a new loan record (createLoan)
    @RequestMapping(value = "/createLoan", method = RequestMethod.POST)
    public String createLoan(LoanRequest loanRequest) {
        try {
            loanService.createLoan(loanRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Loan Created Successfully :)";
    }

    //function that gets all Loan (getAllLoan)
    @RequestMapping(value = "/getAllLoan", method = RequestMethod.GET)
    public List<Loan> getAllLoan() {
        List<Loan> Loans = loanService.getAllLoan();
        return Loans;
    }
    // This function Updates a record for Loan with user Input (updateLoan)
    @RequestMapping(value = "/updateLoan", method = RequestMethod.POST)
    public String updateLoan(LoanRequest loanRequest) {
        try {
            loanService.createLoan(loanRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Loan updated Successfully :)";
    }
}
