package com.BankSystem.SecondProject_BankSystem.Controllers;

import com.BankSystem.SecondProject_BankSystem.Models.Customer;
import com.BankSystem.SecondProject_BankSystem.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    // the function creates a new customer
    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public String createCustomer(@RequestParam String name, String email, String phone) {
        try {
            customerService.createCustomer(name, email, phone);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Record Created Successfully :)";
    }

    //function that gets all the customer (getAllCustomer)
    @RequestMapping(value = "/getAllCustomer", method = RequestMethod.GET)
    public List<Customer> getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomer();
        return customers;
    }
}
