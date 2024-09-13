package com.example.spring_security_inmemory_test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthenticationExceptionEntity {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
