package com.BankSystem.SecondProject_BankSystem.Services;

import com.BankSystem.SecondProject_BankSystem.Models.CreditCard;
import com.BankSystem.SecondProject_BankSystem.Models.Customer;
import com.BankSystem.SecondProject_BankSystem.Models.Transaction;
import com.BankSystem.SecondProject_BankSystem.Repositories.CreditCardRepository;
import com.BankSystem.SecondProject_BankSystem.Repositories.CustomerRepository;
import com.BankSystem.SecondProject_BankSystem.RequestObject.creditCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void createCreditCard(creditCardRequest creditCardRequest) throws ParseException {
        CreditCard creditCard = new CreditCard(); // create object
        creditCard.setCardNumber(creditCardRequest.getCardNumber());
        creditCard.setCreditLimit(creditCardRequest.getCreditLimit());
        creditCard.setUpdatedDate(new Date()); // give current date
        creditCard.setCreatedDate(new Date());// give current date
        creditCard.setIsActive(Boolean.TRUE);
        Customer customer = customerRepository.findById(creditCardRequest.getCustomerID()).get();
        creditCard.setCustomer(customer);
        creditCardRepository.save(creditCard);
    }
}
