package com.example.exam.exception.model;

public class StudentNotFoundException extends RuntimeException{
    private String message;

    public StudentNotFoundException() {}

    public StudentNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}