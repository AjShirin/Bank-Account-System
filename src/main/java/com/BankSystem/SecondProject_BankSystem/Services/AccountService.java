package com.BankSystem.SecondProject_BankSystem.Services;

import com.BankSystem.SecondProject_BankSystem.Models.Account;
import com.BankSystem.SecondProject_BankSystem.Models.Customer;
import com.BankSystem.SecondProject_BankSystem.Repositories.AccountRepository;
import com.BankSystem.SecondProject_BankSystem.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

}
