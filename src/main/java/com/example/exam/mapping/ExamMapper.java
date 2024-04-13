package com.example.exam.mapping;

import com.example.exam.dto.ExamDto;
import com.example.exam.entity.ExamEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ExamMapper {

    public ExamEntity MapDtoToEntity(ExamDto examDto){
        return ExamEntity.builder()
                .lessonCode(examDto.getLessonCode())
                .studentNumber(examDto.getStudentNumber())
                .examDate(examDto.getExamDate())
                .mark(examDto.getMark())
                .build();
    }

    public ExamDto MapEntityToDto(ExamEntity examEntity){
        return ExamDto.builder()
                .lessonCode(examEntity.getLessonCode())
                .studentNumber(examEntity.getStudentNumber())
                .examDate(examEntity.getExamDate())
                .mark(examEntity.getMark())
                .build();
    }

    public List<ExamDto> MatToDtoList(List<ExamEntity> examEntities){
        return examEntities.stream()
                .map(this::MapEntityToDto)
                .collect(Collectors.toList());
    }
}
