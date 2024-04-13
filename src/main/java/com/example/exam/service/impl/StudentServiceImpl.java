package com.example.exam.service.impl;

import com.example.exam.dto.StudentDto;
import com.example.exam.dto.StudentDto;
import com.example.exam.entity.StudentEntity;
import com.example.exam.entity.StudentEntity;
import com.example.exam.exception.model.StudentNotFoundException;
import com.example.exam.mapping.StudentMapper;
import com.example.exam.repository.StudentRepo;
import com.example.exam.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    @Override
    public ResponseEntity<StudentDto> save(StudentDto studentDto) {
        StudentEntity StudentEntity = studentMapper.MapDtoToEntity(studentDto);
        studentRepo.save(StudentEntity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentDto);
    }

    @Override
    public ResponseEntity<List<StudentDto>> getAll() {
        List<StudentDto> studentDto = studentMapper.MatToDtoList((List<StudentEntity>) studentRepo.findAll());

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(studentDto);
    }

    @Override
    public ResponseEntity<StudentDto> getByStudentNumber(int studentNumber) {
        StudentDto studentDto = studentMapper.MapEntityToDto(studentRepo.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with number: " + studentNumber)));
        return ResponseEntity.status(HttpStatus.FOUND).body(studentDto);
    }

    @Override
    public ResponseEntity<Void> deleteAll() {
        studentRepo.deleteAll();
        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleteByStudentNumber(int studentNumber) {
        if (!studentRepo.existsByStudentNumber(studentNumber))
            throw new StudentNotFoundException("Student not found with number: " + studentNumber);
        studentRepo.deleteByStudentNumber(studentNumber);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<StudentDto> update(Long id, StudentEntity StudentEntity) {
        StudentEntity entity = studentRepo.findById(id).orElseThrow();

        entity.setStudentNumber(StudentEntity.getStudentNumber());
        entity.setStudentName(StudentEntity.getStudentName());
        entity.setStudentSurname(StudentEntity.getStudentSurname());
        entity.setClazz(StudentEntity.getClazz());;

        studentRepo.save(entity);

        StudentDto dto = studentMapper.MapEntityToDto(entity);
        return ResponseEntity.ok().body(dto);
    }
}
