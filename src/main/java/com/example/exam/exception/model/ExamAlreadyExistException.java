package com.example.exam.exception.model;

public class ExamAlreadyExistException extends RuntimeException{
    private String message;

    public ExamAlreadyExistException() {}

    public ExamAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
