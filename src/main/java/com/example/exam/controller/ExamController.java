package com.example.exam.controller;

import com.example.exam.dto.ExamDto;
import com.example.exam.entity.ExamEntity;
import com.example.exam.entity.LessonEntity;
import com.example.exam.entity.StudentEntity;
import com.example.exam.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;

    @PostMapping("/save")
    public ResponseEntity<ExamDto> save(@RequestParam String lessonCode, @RequestParam int studentNumber, @RequestParam int mark) {
        return examService.save(lessonCode, studentNumber, mark);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExamDto>> getAll() {
        return examService.getAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ExamDto> getById(@PathVariable Long id) {
        return examService.getById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAll() {
        return examService.deleteAll();
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return examService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ExamDto> update(@PathVariable Long id, @RequestBody ExamEntity examEntity) {
        return examService.update(id, examEntity);
    }
}
