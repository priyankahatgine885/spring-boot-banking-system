package com.cognologix.springboot.dto.bankaccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Transfer amount dto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferAmountDTO {
    private String fromAccountNumber;
    private String toAccountNumber;
    private Double amount;

}