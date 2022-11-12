package com.cognologix.springboot.dto.bankaccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Long id;
    private String accountNumber;
    private String fullName;
    private String phone;
    private double balance;
    private Date createdDt;
    private Date modifiedDt;

}
