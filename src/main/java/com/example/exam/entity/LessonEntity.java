package com.example.exam.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "lessons", schema = "exam")
public class LessonEntity {
    @Id
    @Column(name = "lesson_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "lesson_code", length = 3, unique = true, nullable = false)
    String lessonCode;

    @Column(name = "lesson_name", length = 30, nullable = false)
    String lessonName;

    @Column(name = "class", length = 2, nullable = false)
    int clazz;

    @Column(name = "teacher_name", length = 20, nullable = false)
    String teacherName;

    @Column(name = "teacher_surname", length = 20, nullable = false)
    String teacherSurname;

    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    LocalDateTime updateAt;
}
