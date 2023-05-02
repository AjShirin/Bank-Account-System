package com.BankSystem.SecondProject_BankSystem.Models;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
public class CreditCard extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer cardNumber;

    Double CreditLimit;

    @OneToOne
    @JoinColumn(name="Customer_ID",referencedColumnName = "id")
    Customer customer;


}
