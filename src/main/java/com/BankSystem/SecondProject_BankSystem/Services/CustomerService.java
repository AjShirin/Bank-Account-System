package com.BankSystem.SecondProject_BankSystem.Services;

import com.BankSystem.SecondProject_BankSystem.Models.Customer;
import com.BankSystem.SecondProject_BankSystem.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    // function to create customer
    public void createCustomer(String name, String email, String phone) {
        Customer customer = new Customer(); // create object
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setCreatedDate(new Date()); // give current date
        customer.setUpdatedDate(new Date()); // give current date
        customer.setIsActive(Boolean.TRUE);
        customerRepository.save(customer);
    }

}
