package com.example.exam.controller;

import com.example.exam.dto.LessonDto;
import com.example.exam.entity.LessonEntity;
import com.example.exam.exception.model.MessageModel;
import com.example.exam.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/lesson")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;


    @PostMapping("/save")
    public ResponseEntity<MessageModel> save(@RequestBody LessonDto lessonDto) {
        return lessonService.save(lessonDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LessonDto>> getAll() {
        return lessonService.getAll();
    }

    @GetMapping("/code/{lessonCode}")
    public ResponseEntity<LessonDto> getByLessonCode(@PathVariable String lessonCode) {
        return lessonService.getByLessonCode(lessonCode);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAll() {
        lessonService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/code/{lessonCode}")
    public ResponseEntity<Void> deleteByLessonCode(@PathVariable String lessonCode) {
        return lessonService.deleteByLessonCode(lessonCode);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<LessonDto> update(@PathVariable Long id, @RequestBody LessonEntity lessonEntity) {
        return lessonService.update(id, lessonEntity);
    }
}
