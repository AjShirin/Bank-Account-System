package com.BankSystem.SecondProject_BankSystem.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

     String accountNumber;

     Double balance;

     @ManyToOne
    @JoinColumn(name="Customer_ID",referencedColumnName = "id")
    Customer customer;

}
