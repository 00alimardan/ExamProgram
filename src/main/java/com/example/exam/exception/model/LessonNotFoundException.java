package com.example.exam.exception.model;

public class LessonNotFoundException extends RuntimeException{
    private String message;

    public LessonNotFoundException() {}

    public LessonNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
