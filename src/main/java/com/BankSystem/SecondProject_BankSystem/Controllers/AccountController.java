package com.BankSystem.SecondProject_BankSystem.Controllers;

import com.BankSystem.SecondProject_BankSystem.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public String createAccount(@RequestParam Integer accountNumber, Double balance,Integer customerID) {
        try {
            accountService.createAccount(accountNumber,balance,customerID);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Account Created Successfully :)";
    }


}
