package com.cognologix.springboot.dto.bankaccount;

import com.cognologix.springboot.dto.BaseResponse;
import com.cognologix.springboot.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The type Customer list response.
 */
@Getter
@Setter
public class CustomerListResponse extends BaseResponse {
    private List<Customer> customerList;
    private Integer size;

    /**
     * Instantiates a new Customer list response.
     *
     * @param customers the acc
     * @param size      the size
     */
    public CustomerListResponse(List<Customer> customers, Integer size) {
        super(true);
        customerList = customers;
        this.size = size;
    }
}
