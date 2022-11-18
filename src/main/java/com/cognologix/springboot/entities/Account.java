package com.cognologix.springboot.entities;

import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * The type Account.
 */
@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(max = 15)
    @Column(name = "account_number")
    private String accountNumber;


//    @NotBlank
//    @Column(name = "bankInfo")
//    private BankInfo bankInfo;

    @NotBlank
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customerInfo;

    @NotBlank
    @Column(name = "balance")
    private double balance;

    @NotBlank
    @Column(name = "accountType")
    private Integer accountType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_dt")
    @CreationTimestamp
    private Date createdDt;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_dt")
    @UpdateTimestamp
    private Date modifiedDt;

    /**
     * Instantiates a new Account.
     *
     * @param acc the acc
     */
    public Account(AccountDTO acc) {
        accountNumber = acc.getAccountNumber();
        balance = acc.getBalance();
        accountType = acc.getAccountType().getId();
    }

}
