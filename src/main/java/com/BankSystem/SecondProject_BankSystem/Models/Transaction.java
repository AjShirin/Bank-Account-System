package com.BankSystem.SecondProject_BankSystem.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "account_transaction")
public class Transaction extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Double amount;

    Date TransactionDate;
}
