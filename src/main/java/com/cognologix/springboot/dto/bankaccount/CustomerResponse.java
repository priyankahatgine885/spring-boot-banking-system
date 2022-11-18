package com.cognologix.springboot.dto.bankaccount;

import com.cognologix.springboot.dto.BaseResponse;
import com.cognologix.springboot.entities.Customer;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Customer response.
 */
@Getter
@Setter
public class CustomerResponse extends BaseResponse {
    private Customer customer;

    /**
     * Instantiates a new Customer response.
     *
     * @param customer the customer
     */
    public CustomerResponse(Customer customer) {
        super(true);
        this.customer = customer;
    }

    /**
     * Instantiates a new Customer response.
     *
     * @param isSuccess the is success
     */
    public CustomerResponse(boolean isSuccess) {
        super(isSuccess);
    }
}
