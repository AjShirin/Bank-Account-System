package com.BankSystem.SecondProject_BankSystem.Services;

import com.BankSystem.SecondProject_BankSystem.Models.Account;
import com.BankSystem.SecondProject_BankSystem.Models.Customer;
import com.BankSystem.SecondProject_BankSystem.Repositories.AccountRepository;
import com.BankSystem.SecondProject_BankSystem.Repositories.CustomerRepository;
import com.BankSystem.SecondProject_BankSystem.RequestObject.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    // function to create new Account (createAccount)
    public void createAccount(Integer accountNumber, Double balance, Integer customerID) {
        Account account = new Account(); // create object
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);
        account.setCreatedDate(new Date()); // give current date
        account.setUpdatedDate(new Date()); // give current date
        account.setIsActive(Boolean.TRUE);
        Customer customer = customerRepository.findById(customerID).get();
        account.setCustomer(customer);
        accountRepository.save(account);
    }
    //function that gets all the Account (getAllAccount)
    public List<Account> getAllAccount() {
        return accountRepository.getAllAccount();
    }

    // Function that updates Account (whole row) [updateAccount]
    public String updateAccount(AccountRequest accountRequest) {
        try {
            Account account = accountRepository.getAccountById(accountRequest.getId());
            account.setBalance(accountRequest.getBalance());
            account.setUpdatedDate(new Date());
            account.setIsActive(Boolean.TRUE);
            accountRepository.save(account);
            return "The Account ID:" + accountRequest.getId() + " has been successfully updated :)";
        } catch (Exception e) {
            return "An error occurred, record is not updated. Please try again.";
        }
    }
}
