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
@Table(name = "student", schema = "exam")
public class StudentEntity {
    @Id
    @Column(name = "sudent_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "student_number", length = 5, nullable = false, unique = true)
    int studentNumber;

    @Column(name = "student_name", length = 20, nullable = false)
    String studentName;

    @Column(name = "student_surname", length = 20, nullable = false)
    String studentSurname;

    @Column(name = "class", length = 2, nullable = false)
    int clazz;

    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    LocalDateTime updateAt;
}
