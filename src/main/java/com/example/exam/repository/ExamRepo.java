package com.example.exam.repository;

import com.example.exam.entity.ExamEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepo extends CrudRepository<ExamEntity, Long> {
}
