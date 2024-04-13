package com.example.exam.service.impl;

import com.example.exam.dto.LessonDto;
import com.example.exam.entity.LessonEntity;
import com.example.exam.exception.model.LessonNotFoundException;
import com.example.exam.mapping.LessonMapper;
import com.example.exam.exception.model.MessageModel;
import com.example.exam.repository.LessonRepo;
import com.example.exam.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepo lessonRepo;
    private final LessonMapper lessonMapper;

    @Override
    public ResponseEntity<MessageModel> save(LessonDto lessonDto) {
        LessonEntity lessonEntity = lessonMapper.MapDtoToEntity(lessonDto);
        lessonRepo.save(lessonEntity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageModel("Lesson saved successfully",lessonDto));
    }

    @Override
    public ResponseEntity<List<LessonDto>> getAll() {
        List<LessonDto> lessonDto = lessonMapper.MatToDtoList((List<LessonEntity>) lessonRepo.findAll());

        return ResponseEntity.status(HttpStatus.FOUND)
                    .body(lessonDto);
    }

    @Override
    public ResponseEntity<LessonDto> getByLessonCode(String lessonCode) {
        LessonDto lessonDto = lessonMapper.MapEntityToDto(lessonRepo.findByLessonCode(lessonCode)
                .orElseThrow(() -> new LessonNotFoundException("Lesson not found with code: " + lessonCode)));
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(lessonDto);
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleteAll() {
        lessonRepo.deleteAll();
        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleteByLessonCode(String lessonCode) {
        if (!lessonRepo.existsByLessonCode(lessonCode))
            throw new LessonNotFoundException("Lesson not found with code: " + lessonCode);

        lessonRepo.deleteByLessonCode(lessonCode);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<LessonDto> update(Long id, LessonEntity lessonEntity) {
        LessonEntity entity = lessonRepo.findById(id).orElseThrow();

        entity.setLessonCode(lessonEntity.getLessonCode());
        entity.setLessonName(lessonEntity.getLessonName());
        entity.setClazz(lessonEntity.getClazz());
        entity.setTeacherName(lessonEntity.getTeacherName());
        entity.setTeacherSurname(lessonEntity.getTeacherSurname());

        lessonRepo.save(entity);

        LessonDto dto = lessonMapper.MapEntityToDto(entity);
        return ResponseEntity.ok().body(dto);
    }
}
