package com.example.exam.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamDto {

    String lessonCode;

    int studentNumber;

    LocalDateTime examDate;

    int mark;
}
