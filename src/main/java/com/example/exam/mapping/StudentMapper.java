package com.example.exam.mapping;

import com.example.exam.dto.StudentDto;
import com.example.exam.entity.StudentEntity;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

    public StudentEntity MapDtoToEntity(StudentDto StudentDto){
        return StudentEntity.builder()
                .studentNumber(StudentDto.getStudentNumber())
                .studentName(StudentDto.getStudentName())
                .studentSurname(StudentDto.getStudentSurname())
                .clazz(StudentDto.getClazz())
                .build();
    }

    public StudentDto MapEntityToDto(StudentEntity StudentEntity){
        return StudentDto.builder()
                .studentNumber(StudentEntity.getStudentNumber())
                .studentName(StudentEntity.getStudentName())
                .studentSurname(StudentEntity.getStudentSurname())
                .clazz(StudentEntity.getClazz())
                .build();
    }

    public List<StudentDto> MatToDtoList(List<StudentEntity> StudentEntities){
        return StudentEntities.stream()
                .map(this::MapEntityToDto)
                .collect(Collectors.toList());
    }
}
