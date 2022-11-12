package com.cognologix.springboot.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "full_Name")
    private String fullName;
    private String phone;
    private double balance;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_dt")
    @CreationTimestamp
    private Date createdDt;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_dt")
    @UpdateTimestamp
    private Date modifiedDt;

    @Override
    public String toString() {
        return String.format("AccountNO : %-5s FullName : %-5s Phone : %-5s  Balance : %-5.2f", this.accountNumber, this.fullName,this.phone, this.balance);
    }
}
