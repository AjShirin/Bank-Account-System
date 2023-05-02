package com.BankSystem.SecondProject_BankSystem.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class creditCardRequest {
    Integer cardNumber;

    Double CreditLimit;

    Integer customerID;
}
