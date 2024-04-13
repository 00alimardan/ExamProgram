package com.example.exam.service.impl;

import com.example.exam.dto.ExamDto;
import com.example.exam.entity.ExamEntity;
import com.example.exam.entity.LessonEntity;
import com.example.exam.entity.StudentEntity;
import com.example.exam.exception.model.ExamAlreadyExistException;
import com.example.exam.exception.model.LessonNotFoundException;
import com.example.exam.exception.model.StudentNotFoundException;
import com.example.exam.mapping.ExamMapper;
import com.example.exam.repository.ExamRepo;
import com.example.exam.repository.LessonRepo;
import com.example.exam.repository.StudentRepo;
import com.example.exam.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {

    private final ExamRepo examRepo;
    private final ExamMapper examMapper;
    private final StudentRepo studentRepo;
    private final LessonRepo lessonRepo;

    @Override
    public ResponseEntity<ExamDto> save(String lessonCode, int studentNumber, int mark) {
        LessonEntity lessonEntity = lessonRepo.findByLessonCode(lessonCode)
                .orElseThrow(() -> new LessonNotFoundException("Lesson not found with code: " + lessonCode));
        StudentEntity studentEntity = studentRepo.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with number: " + studentNumber));

        for (ExamEntity entity: examRepo.findAll()){
            if (entity.getLessonCode().equals(lessonCode) && entity.getStudentNumber()==studentNumber){
                throw new ExamAlreadyExistException("You already pass this exam");
            }
        }

        ExamEntity examEntity = new ExamEntity();
        examEntity.setLessonCode(lessonEntity.getLessonCode());
        examEntity.setStudentNumber(studentEntity.getStudentNumber());
        examEntity.setMark(mark);

        examRepo.save(examEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(examMapper.MapEntityToDto(examEntity));
    }

    @Override
    public ResponseEntity<List<ExamDto>> getAll() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(examMapper.MatToDtoList((List<ExamEntity>) examRepo.findAll()));
    }

    @Override
    public ResponseEntity<ExamDto> getById(Long id) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(examMapper.MapEntityToDto(examRepo.findById(id).orElseThrow()));
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleteAll() {
        examRepo.deleteAll();
        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleteById(Long id) {
        if (!examRepo.existsById(id))
            throw new RuntimeException();
        examRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ExamDto> update(Long id, ExamEntity examEntity) {
        ExamEntity entity = examRepo.findById(id).orElseThrow();

        entity.setLessonCode(examEntity.getLessonCode());
        entity.setStudentNumber(examEntity.getStudentNumber());
        entity.setMark(examEntity.getMark());

        examRepo.save(entity);

        return ResponseEntity.ok(examMapper.MapEntityToDto(examEntity));
    }
}
