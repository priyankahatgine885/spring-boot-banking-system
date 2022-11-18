package com.cognologix.springboot.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * The enum Account type.
 */
public enum AccountType {

    /**
     * Saving account type.
     */
    SAVING(1, "Saving"),

    /**
     * The Fixed deposit.
     */
    FIXED_DEPOSIT(2, "Fixed Deposit"),

    /**
     * Current account type.
     */
    CURRENT(3, "Current"),

    /**
     * The Recurring deposit.
     */
    RECURRING_DEPOSIT(4, "Recurring Deposit");

    private final Integer id;
    private final String name;

    private static final Map<Integer, AccountType> byId = new HashMap<Integer, AccountType>();

    static {
        for (AccountType e : AccountType.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }

    private AccountType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public static AccountType getById(Integer id) {
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
