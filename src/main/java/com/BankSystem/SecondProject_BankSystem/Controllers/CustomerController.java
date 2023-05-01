package com.BankSystem.SecondProject_BankSystem.Controllers;

import com.BankSystem.SecondProject_BankSystem.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping(value = "Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public String createCustomer(@RequestParam String name, String email, String phone)  {
        try {
            customerService.createCustomer(name,email,phone);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Created Successfully :)";
    }
}
