package com.example.exam.repository;

import com.example.exam.dto.LessonDto;
import com.example.exam.entity.LessonEntity;
import com.example.exam.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends CrudRepository<StudentEntity, Long> {

    Optional<StudentEntity> findByStudentNumber(int studentNumber);

    boolean existsByStudentNumber(int studentNumber);

    void deleteByStudentNumber(int studentNUmber);
}
