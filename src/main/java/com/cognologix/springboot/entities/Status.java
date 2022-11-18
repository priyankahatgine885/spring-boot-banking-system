package com.cognologix.springboot.entities;

/**
 * The enum Status.
 */
public enum Status {
    /**
     * Active status.
     */
    ACTIVE(1, "Active"),

    /**
     * Inactive status.
     */
    INACTIVE(1, "InActive");

    private final Integer id;
    private final String name;

    private Status(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
