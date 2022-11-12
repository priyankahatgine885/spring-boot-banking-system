package com.cognologix.springboot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse implements Serializable {
    private String message;
    private boolean success;

    public BaseResponse(final boolean success){
        this.success = success;
    }
    public boolean getSuccess(){
        return success;
    }
}
