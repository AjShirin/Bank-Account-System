package com.BankSystem.SecondProject_BankSystem.Controllers;

import com.BankSystem.SecondProject_BankSystem.Models.Transaction;
import com.BankSystem.SecondProject_BankSystem.RequestObject.TransactionRequest;
import com.BankSystem.SecondProject_BankSystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "/createTransaction", method = RequestMethod.POST)
    public String createTransaction(TransactionRequest transactionRequest) {
        try {
            transactionService.createTransaction(transactionRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Transaction Created Successfully :)";
    }

    //function that gets all the Transaction (getAllTransaction)
    @RequestMapping(value = "/getAllTransaction", method = RequestMethod.GET)
    public List<Transaction> getAllTransaction() {
        List<Transaction> transactions = transactionService.getAllTransaction();
        return transactions;
    }

    // This function Updates a record for Transaction with user Input (updateTransaction)
    @RequestMapping(value = "/updateTransaction", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTransaction(TransactionRequest transactionRequest) {
        // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        try {
            String responseMsg = transactionService.updateTransaction(transactionRequest);
            return ResponseEntity.ok().body(responseMsg);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred, Transaction is not updated. Please try again.");
        }
    }
    // function that changes that is active to false (deleteTransactionById)
    @RequestMapping(value = "/deleteTransactionById", method = RequestMethod.POST)
    public String deleteTransactionById(TransactionRequest transactionRequest)  {
        try {
            transactionService.deleteTransactionById(transactionRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Deleted Successfully :)";
    }

}
