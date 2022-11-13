package com.cognologix.springboot.dto.bankaccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepositWithdrawAmount {
    private Double amount;
    private String accountNumber;
}
