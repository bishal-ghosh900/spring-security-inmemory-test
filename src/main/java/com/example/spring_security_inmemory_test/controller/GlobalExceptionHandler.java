package com.example.spring_security_inmemory_test.controller;


import com.example.spring_security_inmemory_test.entity.EmployeeExceptionEntity;
import com.example.spring_security_inmemory_test.exception.EmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EmployeeException.class})
    public ResponseEntity<EmployeeExceptionEntity> handleEmployeeExceptions(Exception exception) {
        EmployeeExceptionEntity entity = new EmployeeExceptionEntity();
        entity.setStatus(HttpStatus.NOT_FOUND.value());
        entity.setMessage(exception.getMessage());
        entity.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entity);
    }


    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionEntity> handleGlobalExceptions(Exception exception) {
        EmployeeExceptionEntity entity = new EmployeeExceptionEntity();
        entity.setStatus(HttpStatus.BAD_REQUEST.value());
        entity.setMessage(exception.getMessage());
        entity.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entity);
    }
}
