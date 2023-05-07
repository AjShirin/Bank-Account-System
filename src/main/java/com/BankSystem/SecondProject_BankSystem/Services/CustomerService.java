package com.BankSystem.SecondProject_BankSystem.Services;

import com.BankSystem.SecondProject_BankSystem.Models.Customer;
import com.BankSystem.SecondProject_BankSystem.Repositories.CustomerRepository;
import com.BankSystem.SecondProject_BankSystem.RequestObject.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    // function to create customer (createCustomer)
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

    //function that gets all the Customers (getAllCustomer)
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    // Function that updates Customer (whole row) [updateCustomer]
    public String updateCustomer(CustomerRequest customerRequest) {
        try {
            Customer customer = customerRepository.getCustomerById(customerRequest.getId());
            customer.setName(customerRequest.getName());
            customer.setEmail(customerRequest.getEmail());
            customer.setPhone(customerRequest.getPhone());
            customer.setUpdatedDate(new Date());
            customer.setIsActive(Boolean.TRUE);
            customerRepository.save(customer);
            return "The Customer ID:" + customerRequest.getId() + " has been successfully updated :)";
        } catch (Exception e) {
            return "An error occurred, record is not updated. Please try again.";
        }
    }
    // function that makes the is active to false (deleteCustomerById)
    public void deleteCustomerById(CustomerRequest customerRequest) {
        Customer customer = customerRepository.getCustomerById(customerRequest.getId());
        customer.setIsActive(Boolean.FALSE);
        customerRepository.save(customer);
    }

}
