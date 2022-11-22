package com.cognologix.springboot.entities;

import java.util.UUID;

/**
 * The type Transaction.
 */
public class Transaction {
    private final String transactionId = UUID.randomUUID().toString();
    private String fromAccountNumber;
    private String toAccountNumber;
    private Double amount;
    private TransactionType transactionType;
}
