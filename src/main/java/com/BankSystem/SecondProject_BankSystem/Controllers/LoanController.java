package com.BankSystem.SecondProject_BankSystem.Controllers;

import com.BankSystem.SecondProject_BankSystem.RequestObject.LoanRequest;
import com.BankSystem.SecondProject_BankSystem.Services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "loan")
public class LoanController {

    @Autowired
    LoanService loanService;

    @RequestMapping(value = "/createLoan", method = RequestMethod.POST)
    public String createLoan(LoanRequest loanRequest) {
        try {
            loanService.createLoan(loanRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Loan Created Successfully :)";
    }
}
