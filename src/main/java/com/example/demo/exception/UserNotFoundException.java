package com.example.demo.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserNotFoundException extends Exception {
    private String errorCode;
    private String message;
}
