package com.cognologix.springboot.dto.bankaccount;

import com.cognologix.springboot.dto.BaseResponse;
import com.cognologix.springboot.entities.Account;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountResponse extends BaseResponse {
    private Account account;

    public AccountResponse(Account acc) {
        super(true);
        this.account = acc;
    }

    public AccountResponse(boolean isSuccess) {
        super(isSuccess);
    }

}
