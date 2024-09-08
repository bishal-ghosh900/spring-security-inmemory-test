package com.example.spring_security_inmemory_test.exception;

public class EmployeeException extends RuntimeException {
    
    public EmployeeException(String message) {
        super(message);
    }

    public static EmployeeException of(String message) {
        return new EmployeeException(message);
    }

}
