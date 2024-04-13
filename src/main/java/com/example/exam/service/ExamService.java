package com.example.exam.service;

import com.example.exam.dto.ExamDto;
import com.example.exam.entity.ExamEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExamService {

    ResponseEntity<ExamDto> save(String lessonCode, int studentNumber, int studentMark);
    ResponseEntity<List<ExamDto>> getAll();
    ResponseEntity<ExamDto> getById(Long id);
    ResponseEntity<Void> deleteAll();
    ResponseEntity<Void> deleteById(Long id);
    ResponseEntity<ExamDto> update(Long id, ExamEntity ExamEntity);
}