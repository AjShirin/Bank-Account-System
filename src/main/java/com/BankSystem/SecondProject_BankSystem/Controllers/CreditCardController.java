package com.BankSystem.SecondProject_BankSystem.Controllers;

import com.BankSystem.SecondProject_BankSystem.RequestObject.creditCardRequest;
import com.BankSystem.SecondProject_BankSystem.Services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "creditCard")
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @RequestMapping(value = "/createCreditCard", method = RequestMethod.POST)
    public String createCreditCard(creditCardRequest creditCardRequestObj) {
        try {
            creditCardService.createCreditCard(creditCardRequestObj);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Account Created Successfully :)";
    }
}
