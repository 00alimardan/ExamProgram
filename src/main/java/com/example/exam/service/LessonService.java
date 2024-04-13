package com.example.exam.service;

import com.example.exam.dto.LessonDto;
import com.example.exam.entity.LessonEntity;
import com.example.exam.exception.model.MessageModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LessonService {


    ResponseEntity<MessageModel> save(LessonDto lessonDto);
    ResponseEntity<List<LessonDto>> getAll();
    ResponseEntity<LessonDto> getByLessonCode(String lessonCode);
    ResponseEntity<Void> deleteAll();
    ResponseEntity<Void> deleteByLessonCode(String lessonCode);
    ResponseEntity<LessonDto> update(Long id, LessonEntity lessonEntity);
}
