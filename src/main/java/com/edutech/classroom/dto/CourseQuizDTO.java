package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseQuiz;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.Instant;

@Data
public class CourseQuizDTO {
    private Integer id;

    @NotBlank(message = "El curso no puede estar vacío")
    private Integer courseId;

    @NotBlank(message = "El titulo no puede estar vacío")
    private String title;

    @NotBlank(message = "La descripcion no puede estar vacío")
    private String description;

    @NotBlank(message = "El tipo de quiz no puede estar vacío")
    private String quizType;

    @NotBlank(message = "No puede estar vacío")
    private Instant createdAt;


    public static CourseQuizDTO fromEntity(CourseQuiz entity) {
        CourseQuizDTO dto = new CourseQuizDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setQuizType(entity.getQuizType());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }


    public CourseQuiz toEntity() {
        CourseQuiz entity = new CourseQuiz();
        entity.setId(this.id);

        Course course = new Course();
        course.setId(this.courseId);
        entity.setCourse(course);

        entity.setTitle(this.title);
        entity.setDescription(this.description);
        entity.setQuizType(this.quizType);
        entity.setCreatedAt(this.createdAt);
        return entity;
    }
}
