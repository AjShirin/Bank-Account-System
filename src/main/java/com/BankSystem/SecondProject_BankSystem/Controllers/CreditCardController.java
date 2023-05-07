package com.BankSystem.SecondProject_BankSystem.Controllers;

import com.BankSystem.SecondProject_BankSystem.Models.CreditCard;
import com.BankSystem.SecondProject_BankSystem.RequestObject.creditCardRequest;
import com.BankSystem.SecondProject_BankSystem.Services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return "Credit Card Created Successfully :)";
    }

    //function that gets all CreditCard (getAllCreditCard)
    @RequestMapping(value = "/getAllCreditCard", method = RequestMethod.GET)
    public List<CreditCard> getAllCreditCard() {
        List<CreditCard> creditCards = creditCardService.getAllCreditCard();
        return creditCards;
    }

    // This function Updates a record for Credit Card with user Input (updateCreditCard)
    @RequestMapping(value = "/updateCreditCard", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCreditCard(creditCardRequest creditCardRequest) {
        // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        try {
            String responseMsg = creditCardService.updateCreditCard(creditCardRequest);
            return ResponseEntity.ok().body(responseMsg);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred, Account is not updated. Please try again.");
        }
    }
    // function that changes that is active to false (deleteCreditCardById)
    @RequestMapping(value = "/deleteCreditCardById", method = RequestMethod.POST)
    public String deleteCreditCardById(creditCardRequest creditCardRequest)  {
        try {
            creditCardService.deleteCreditCardById(creditCardRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Deleted Successfully :)";
    }
}
