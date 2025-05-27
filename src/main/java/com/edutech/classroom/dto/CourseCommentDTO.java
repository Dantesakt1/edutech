package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseComment;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class CourseCommentDTO {
    private Integer id;

    @NotNull(message = "El Curso no puede estar vacío")
    private Integer courseId;

    @NotNull(message = "El user no puede estar vacío")
    private Integer userId;

    @NotNull(message = "El comentario no puede estar vacío")
    private String commentText;

    @NotNull(message = "La clasificacion no puede estar vacía")
    private Integer rating;

    @NotNull(message = "No puede estar vacío")
    private Instant createdAt;

    public static CourseCommentDTO fromEntity(CourseComment entity) {
        CourseCommentDTO dto = new CourseCommentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setUserId(entity.getUser().getId());
        dto.setCommentText(entity.getCommentText());
        dto.setRating(entity.getRating());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public CourseComment toEntity() {
        CourseComment entity = new CourseComment();
        entity.setId(this.id);

        Course course = new Course();
        course.setId(this.courseId);
        entity.setCourse(course);

        User user = new User();
        user.setId(this.userId);
        entity.setUser(user);

        entity.setCreatedAt(this.createdAt);
        entity.setRating(this.rating);
        entity.setCommentText(this.commentText);
        return entity;
    }

}
