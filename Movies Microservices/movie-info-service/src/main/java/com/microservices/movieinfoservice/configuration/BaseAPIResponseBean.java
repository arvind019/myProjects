package com.microservices.movieinfoservice.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashMap;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseAPIResponseBean<T> {
    private String code;
    private String status;
    private String message;
    private T data;
    private HashMap<String, Object> error;

    public BaseAPIResponseBean() {
        super();
    }
}
