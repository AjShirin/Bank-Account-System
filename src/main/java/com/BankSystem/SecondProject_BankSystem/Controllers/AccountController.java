package com.BankSystem.SecondProject_BankSystem.Controllers;

import com.BankSystem.SecondProject_BankSystem.Models.Account;
import com.BankSystem.SecondProject_BankSystem.RequestObject.AccountRequest;
import com.BankSystem.SecondProject_BankSystem.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;
import java.util.List;

@RestController
@RequestMapping(value = "account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public String createAccount(@RequestParam Integer accountNumber, Double balance, Integer customerID) {
        try {
            accountService.createAccount(accountNumber, balance, customerID);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Account Created Successfully :)";
    }

    //function that gets all the account (getAllAccount)
    @RequestMapping(value = "/getAllAccount", method = RequestMethod.GET)
    public List<Account> getAllAccount() {
        List<Account> accounts = accountService.getAllAccount();
        return accounts;
    }

    // This function Updates a record for Account with user Input (updateAccount)
    @RequestMapping(value = "/updateAccount", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAccount(AccountRequest accountRequest) {
        // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        try {
            String responseMsg = accountService.updateAccount(accountRequest);
            return ResponseEntity.ok().body(responseMsg);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred, Account is not updated. Please try again.");
        }
    }
    // function that changes that is active to false (deleteAccountById)
    @RequestMapping(value = "/deleteAccountById", method = RequestMethod.POST)
    public String deleteAccountById(AccountRequest accountRequest)  {
        try {
            accountService.deleteAccountById(accountRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Deleted Successfully :)";
    }
    // Question 2. Function that Retrieves the account balance for a specific account.
    @RequestMapping(value = "getBalanceForSpecificAccount", method = RequestMethod.GET)
    public double getBalanceForSpecificAccount(@RequestParam Integer id) {
        return accountService.getBalanceForSpecificAccount(id);
    }
    // Question 3.Create a function to Update the account balance when a transaction is made.
//    @RequestMapping(value = "updateAccountWhenTransactionMade", method = RequestMethod.PUT)
//    public ResponseEntity<String> updateAccountWhenTransactionMade(@RequestBody AccountRequest accountRequest) {
//        accountService.updateAccountBalance(accountRequest);
//        return ResponseEntity.ok("Account balance updated successfully");
//    }






//    @RequestMapping(value = "/getBalanceForSpecificAccount", method = RequestMethod.GET)
//    public ResponseEntity<String> createTransaction(Integer accountId, @RequestBody AccountRequest accountRequest) {
//        String statement = accountService.generateMonthlyStatement(accountId);
//        return ResponseEntity.ok(statement);
//    }


    @RequestMapping(value = "/accountStatement", method = RequestMethod.GET)
    public ResponseEntity<String> generateMonthlyStatementForAccount(@RequestParam Integer accountId) {
        String statement = accountService.generateMonthlyStatement(accountId);
        return ResponseEntity.ok(statement);
    }

}
