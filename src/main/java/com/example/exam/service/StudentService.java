package com.example.exam.service;

import com.example.exam.dto.StudentDto;
import com.example.exam.entity.StudentEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<StudentDto> save(StudentDto StudentDto);
    ResponseEntity<List<StudentDto>> getAll();
    ResponseEntity<StudentDto> getByStudentNumber(int studentNumber);
    ResponseEntity<Void> deleteAll();
    ResponseEntity<Void> deleteByStudentNumber(int studentNumber);
    ResponseEntity<StudentDto> update(Long id, StudentEntity StudentEntity);
}
