package com.BankSystem.SecondProject_BankSystem.RequestObject;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class TransactionRequest {

    Double amount;

    String TransactionDate;
    Integer creditCardId;
}
