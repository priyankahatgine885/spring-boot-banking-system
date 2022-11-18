package com.cognologix.springboot.dto.bankaccount;

import com.cognologix.springboot.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * The type Customer dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
    private String email;
    private String aadharNumber;
    private Date createdDt;
    private Date modifiedDt;

    /**
     * Instantiates a new Customer dto.
     *
     * @param customer the customer info
     */
    public CustomerDTO(Customer customer) {
        id = customer.getId();
        firstName = customer.getFirstName();
        middleName = customer.getMiddleName();
        lastName = customer.getLastName();
        phone = customer.getPhone();
        email = customer.getEmail();
        aadharNumber = customer.getAadharNumber();
        createdDt = customer.getCreatedDt();
        modifiedDt = customer.getModifiedDt();
    }
}
