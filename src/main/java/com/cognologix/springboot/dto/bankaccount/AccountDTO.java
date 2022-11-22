package com.cognologix.springboot.dto.bankaccount;

import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.entities.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * The type Account dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Integer id;
    private String accountNumber;

    private CustomerDTO customerInfo;
    private Double balance;
    private AccountType accountType;

    private Date createdDt;

    private Date modifiedDt;

    /**
     * Instantiates a new Account dto.
     *
     * @param account the account
     */
    public AccountDTO(Account account) {
        id = account.getId();
        accountNumber = account.getAccountNumber();
        customerInfo = new CustomerDTO(account.getCustomerInfo());
        balance = account.getBalance();
        accountType = AccountType.getById(account.getAccountType());
    }
}
