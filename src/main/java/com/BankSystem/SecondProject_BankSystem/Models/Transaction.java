package com.BankSystem.SecondProject_BankSystem.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "account_transaction")
public class Transaction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Double amount;

    Date transactionDate;

//    Integer account;

    @ManyToOne // Many transaction to one credit card
    @JoinColumn(name = "CreditCard_id", referencedColumnName = "id")
    CreditCard creditCard;

    @ManyToOne // Many transaction to one Account card
    @JoinColumn(name = "Account_id", referencedColumnName = "id")
    Account account;
}
