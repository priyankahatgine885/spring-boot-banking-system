package com.cognologix.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The type Bank info.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class BankInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BANK_ID")
    private Long id;

    private String branchName;

    private Integer branchCode;

}
