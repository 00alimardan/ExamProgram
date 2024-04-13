package com.example.exam.repository;

import com.example.exam.entity.LessonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LessonRepo extends CrudRepository<LessonEntity, Long> {
    void deleteByLessonCode(String lessonCode);
    Optional<LessonEntity> findByLessonCode(String lessonCode);
    boolean existsByLessonCode(String lessonCode);
}

