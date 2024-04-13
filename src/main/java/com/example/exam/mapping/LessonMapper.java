package com.example.exam.mapping;

import com.example.exam.dto.LessonDto;
import com.example.exam.entity.LessonEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LessonMapper {

    public LessonEntity MapDtoToEntity(LessonDto lessonDto){
        return LessonEntity.builder()
                .lessonCode(lessonDto.getLessonCode())
                .lessonName(lessonDto.getLessonName())
                .clazz(lessonDto.getClazz())
                .teacherName(lessonDto.getTeacherName())
                .teacherSurname(lessonDto.getTeacherSurname())
                .build();
    }

    public LessonDto MapEntityToDto(LessonEntity lessonEntity){
        return LessonDto.builder()
                .lessonCode(lessonEntity.getLessonCode())
                .lessonName(lessonEntity.getLessonName())
                .clazz(lessonEntity.getClazz())
                .teacherName(lessonEntity.getTeacherName())
                .teacherSurname(lessonEntity.getTeacherSurname())
                .build();
    }

    public List<LessonDto> MatToDtoList(List<LessonEntity> lessonEntities){
        return lessonEntities.stream()
                .map(this::MapEntityToDto)
                .collect(Collectors.toList());
    }
}
