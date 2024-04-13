package com.example.exam.exception;


import com.example.exam.exception.model.ErrorModel;
import com.example.exam.exception.model.ExamAlreadyExistException;
import com.example.exam.exception.model.LessonNotFoundException;
import com.example.exam.exception.model.StudentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ExamAlreadyExistException.class)
    public ResponseEntity<ErrorModel> getExamAlreadyExistException(ExamAlreadyExistException ex){
        var errorModel = new ErrorModel(HttpStatus.ALREADY_REPORTED.value(), ex.getMessage());
        log.error(String.valueOf(errorModel));
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(errorModel);
    }

    @ExceptionHandler(value = LessonNotFoundException.class)
    public ResponseEntity<ErrorModel> getLessonNotFoundException(LessonNotFoundException ex){
        var errorModel = new ErrorModel(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        log.error(String.valueOf(errorModel));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorModel);
    }

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<ErrorModel> getStudentNotFoundException(StudentNotFoundException ex){
        var errorModel = new ErrorModel(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        log.error(String.valueOf(errorModel));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorModel);
    }
}
