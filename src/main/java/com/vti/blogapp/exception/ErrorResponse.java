package com.vti.blogapp.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ErrorResponse {
    private String timestamp;
    private String message;
    private Map<String, String> error;

    public ErrorResponse(String message) {
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
    }

    public ErrorResponse(String message, Map<String, String> error) {
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
        this.error = error;
    }


}
