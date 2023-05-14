package com.BankSystem.SecondProject_BankSystem.Services;

import com.BankSystem.SecondProject_BankSystem.Models.CreditCard;
import com.BankSystem.SecondProject_BankSystem.Models.Transaction;
import com.BankSystem.SecondProject_BankSystem.Repositories.CreditCardRepository;
import com.BankSystem.SecondProject_BankSystem.Repositories.TransactionRepository;
import com.BankSystem.SecondProject_BankSystem.RequestObject.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    // function to create new transaction record (createTransaction)
    public void createTransaction(TransactionRequest transactionRequest) throws ParseException {
        Transaction transaction = new Transaction(); // create object
        transaction.setAmount(transactionRequest.getAmount());
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(transactionRequest.getTransactionDate());
        transaction.setTransactionDate(convertedDateFromStringToDateFormat);
        transaction.setUpdatedDate(new Date()); // give current date
        transaction.setCreatedDate(new Date());// give current date
        transaction.setIsActive(Boolean.TRUE);
        CreditCard creditCard = creditCardRepository.findById(transactionRequest.getCreditCardId()).get();
        transaction.setCreditCard(creditCard);
        transactionRepository.save(transaction);

//        Acco
//                balane-amount
    }

    //function that gets all the Transaction (getAllTransaction)
    public List<Transaction> getAllTransaction() {
        return transactionRepository.getAllTransaction();
    }

    //update Transaction (whole row) [updateTransaction]
    public String updateTransaction(TransactionRequest transactionRequest) throws ParseException {
            try {
                Transaction transaction = transactionRepository.getTransactionById(transactionRequest.getId());
                transaction.setAmount(transactionRequest.getAmount());
                DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
                Date convertedDateFromStringToDateFormat = dateFormatter.parse(transactionRequest.getTransactionDate());
                transaction.setTransactionDate(convertedDateFromStringToDateFormat);
                transaction.setUpdatedDate(new Date());
                transaction.setIsActive(Boolean.TRUE);
                transactionRepository.save(transaction);
                return "The transaction ID:" + transaction.getId() + " has been successfully updated :)";
            } catch (Exception e) {
                return "An error occurred, record is not updated. Please try again.";
            }
        }
    // function that makes the is active to false (deleteTransactionById)
    public void deleteTransactionById(TransactionRequest transactionRequest) {
        Transaction transaction = transactionRepository.getTransactionById(transactionRequest.getId());
        transaction.setIsActive(Boolean.FALSE);
        transactionRepository.save(transaction);
    }


}
