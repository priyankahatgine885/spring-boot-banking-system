package com.cognologix.springboot.dto.bankaccount;

import com.cognologix.springboot.dto.BaseResponse;
import com.cognologix.springboot.entities.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The type Account list response.
 */
@Getter
@Setter
public class AccountListResponse extends BaseResponse {
    private List<Account> accountList;
    private Integer size;

    /**
     * Instantiates a new Account list response.
     *
     * @param acc  the acc
     * @param size the size
     */
    public AccountListResponse(List<Account> acc, Integer size) {
        super(true);
        accountList = acc;
        this.size = size;
    }
}
