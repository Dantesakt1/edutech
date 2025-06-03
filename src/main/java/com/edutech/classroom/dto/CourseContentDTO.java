package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseContent;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseContentDTO {

    private Integer id;

    @NotNull(message = "El curso no puede estar vacío")
    private Integer courseId;

    @NotBlank(message = "El titulo no puede estar vacío")
    private String title;

    @NotBlank(message = "El tipo de contenido no puede estar vacío")
    private String contentType;

    @NotBlank(message = "La URL no puede estar vacía")
    private String url;

    @NotNull(message = "El curso no puede estar vacío")
    private Integer orderIndex;

    public static CourseContentDTO fromEntity(CourseContent entity) {
        CourseContentDTO dto = new CourseContentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setTitle(entity.getTitle());
        dto.setContentType(entity.getContentType());
        dto.setUrl(entity.getUrl());
        dto.setOrderIndex(entity.getOrderIndex());
        return dto;
    }

    public CourseContent toEntity() {
        CourseContent entity = new CourseContent();
        entity.setId(this.getId());

        Course course = new Course();
        course.setId(this.getCourseId());
        entity.setCourse(course);

        entity.setTitle(this.getTitle());
        entity.setContentType(this.getContentType());
        entity.setUrl(this.getUrl());
        entity.setOrderIndex(this.getOrderIndex());
        return entity;
    }

}
