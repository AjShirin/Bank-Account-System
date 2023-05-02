package com.BankSystem.SecondProject_BankSystem.Controllers;

import com.BankSystem.SecondProject_BankSystem.Models.Transaction;
import com.BankSystem.SecondProject_BankSystem.RequestObject.TransactionRequest;
import com.BankSystem.SecondProject_BankSystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
