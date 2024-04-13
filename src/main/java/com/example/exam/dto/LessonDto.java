package com.example.exam.dto;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonDto {

    String lessonCode;

    String lessonName;

    int clazz;

    String teacherName;

    String teacherSurname;
}
