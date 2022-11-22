package com.cognologix.springboot.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * The enum Transaction type.
 */
public enum TransactionType {

    /**
     * Deposit transaction type.
     */
    DEPOSIT(1, "Deposit"),


    /**
     * Withdraw transaction type.
     */
    WITHDRAW(2, "Withdraw"),

    /**
     * Cheque transaction type.
     */
    CHEQUE(3, "CHEQUE"),

    /**
     * Onlinepayments transaction type.
     */
    ONLINEPAYMENTS(4, "ONLINEPAYMENTS");

    private final Integer id;
    private final String name;

    private static final Map<Integer, TransactionType> byId = new HashMap<>();

    static {
        for (TransactionType e : TransactionType.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }

    TransactionType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public static TransactionType getById(Integer id) {
        return byId.get(id);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

}
