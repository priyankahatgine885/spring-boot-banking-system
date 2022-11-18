package com.cognologix.springboot.entities;

import com.cognologix.springboot.dto.bankaccount.CustomerDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * The type Customer.
 */
@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "lastName")
    private String lastName;

    @NotBlank
    @Column(name = "phone")
    @Size(max = 15)
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "aadharNumber")
    private String aadharNumber;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_dt")
    @CreationTimestamp
    private Date createdDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_dt")
    @UpdateTimestamp
    private Date modifiedDt;


//    @OneToMany()
//    private Set<Account> accounts;

    /**
     * Instantiates a new Customer.
     *
     * @param customer the customer
     */
    public Customer(CustomerDTO customer) {
        setFirstName(customer.getFirstName());
        setMiddleName((customer.getMiddleName()));
        setLastName(customer.getLastName());
        setPhone(customer.getPhone());
        setEmail(customer.getEmail());
        setAadharNumber(customer.getAadharNumber());
        setCreatedDt(customer.getCreatedDt());
        setModifiedDt(customer.getModifiedDt());
    }

}
