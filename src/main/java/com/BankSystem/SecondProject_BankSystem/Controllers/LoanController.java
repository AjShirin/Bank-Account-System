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
    @RequestMapping(value = "/updateLoan", method = RequestMethod.PUT)
    public ResponseEntity<String> updateLoan(LoanRequest loanRequest) {
        // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        try {
            String responseMsg = loanService.updateLoan(loanRequest);
            return ResponseEntity.ok().body(responseMsg);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred, Account is not updated. Please try again.");
        }
    }
    // function that changes that is active to false (deleteLoanById)
    @RequestMapping(value = "/deleteLoanById", method = RequestMethod.POST)
    public String deleteLoanById(LoanRequest loanRequest)  {
        try {
            loanService.deleteLoanById(loanRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Deleted Successfully :)";
    }
}
