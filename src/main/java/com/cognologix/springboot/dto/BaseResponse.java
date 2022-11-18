package com.cognologix.springboot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * The type Base response.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse implements Serializable {

    private String transactionId = UUID.randomUUID().toString();

    private String message;
    private boolean success;

    /**
     * Instantiates a new Base response.
     *
     * @param success the success
     */
    public BaseResponse(boolean success) {
        this.success = success;
    }

    /**
     * Get success boolean.
     *
     * @return the boolean
     */
    public boolean getSuccess() {
        return success;
    }
}
