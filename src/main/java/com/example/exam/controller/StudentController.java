package com.example.exam.controller;

import com.example.exam.dto.StudentDto;
import com.example.exam.entity.StudentEntity;
import com.example.exam.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam/student")
public class StudentController {
    
    private final StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<StudentDto> save(@RequestBody StudentDto studentDto) {
        return studentService.save(studentDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/number/{studentNumber}")
    public ResponseEntity<StudentDto> getByStudentNumber(@PathVariable int studentNumber) {
        return studentService.getByStudentNumber(studentNumber);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAll() {
        studentService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/code/{studentNumber}")
    public ResponseEntity<Void> deleteByStudentNumber(@PathVariable int studentNumber) {
        return studentService.deleteByStudentNumber(studentNumber);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable Long id, @RequestBody StudentEntity studentEntity) {
        return studentService.update(id, studentEntity);
    }
}
