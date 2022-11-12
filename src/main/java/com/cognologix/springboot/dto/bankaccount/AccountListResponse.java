package com.cognologix.springboot.dto.bankaccount;
import com.cognologix.springboot.dto.BaseResponse;
import com.cognologix.springboot.entities.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AccountListResponse extends BaseResponse {
    private List<Account> accountList;
    private Integer size;
    public AccountListResponse(List<Account> acc, Integer size) {
        super(true);
        this.accountList = acc;
        this.size = size;
    }
}
