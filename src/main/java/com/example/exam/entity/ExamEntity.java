package com.example.exam.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "exam", schema = "exam")
public class ExamEntity {
    @Id
    @Column(name = "exam_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "lesson_code", length = 3, nullable = false, unique = true)
    String lessonCode;

    @Column(name = "student_number", length = 5, nullable = false)
    int studentNumber;

    @CreationTimestamp
    @Column(name = "exam_date")
    private LocalDateTime examDate;

    @Column(name = "mark", length = 1, nullable = false)
    int mark;
}
