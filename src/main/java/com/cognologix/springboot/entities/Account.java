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
import java.io.Serializable;
import java.util.Date;

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
    @Column(name = "account_number")
    private String accountNumber;

    @NotBlank
    @Column(name = "full_Name")
    private String fullName;

    @NotBlank
    @Column(name = "phone")
    private String phone;

    @NotBlank
    @Column(name = "balance")
    private double balance;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_dt")
    @CreationTimestamp
    private Date createdDt;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_dt")
    @UpdateTimestamp
    private Date modifiedDt;

    public Account(AccountDTO acc){
        this.setAccountNumber(acc.getAccountNumber());
        this.setFullName(acc.getFullName());
        this.setPhone(acc.getPhone());
        this.setBalance(acc.getBalance());
        this.setCreatedDt(acc.getCreatedDt());
        this.setModifiedDt(acc.getModifiedDt());
    }

}
