package com.cognologix.springboot.dto.bankaccount;

import com.cognologix.springboot.dto.BaseResponse;
import com.cognologix.springboot.entities.Account;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Account response.
 */
@Setter
@Getter
public class AccountResponse extends BaseResponse {
    private Account account;

    /**
     * Instantiates a new Account response.
     *
     * @param acc the acc
     */
    public AccountResponse(Account acc) {
        super(true);
        account = acc;
    }

    /**
     * Instantiates a new Account response.
     *
     * @param message the message
     * @param success the success
     */
    public AccountResponse(String message, Boolean success) {
        super(success);
        super.setMessage(message);
    }

    /**
     * Instantiates a new Account response.
     *
     * @param isSuccess the is success
     */
    public AccountResponse(boolean isSuccess) {
        super(isSuccess);
    }

}
