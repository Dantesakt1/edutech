package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseCategory;
import com.edutech.classroom.entity.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data

public class CourseDTO {
    private Integer id;

    @NotBlank(message = "El título no puede estar vacío")
    @Size(max = 200, message = "El título no puede superar los 200 caracteres")
    private String title;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 800, message = "La descripción no puede superar los 800 caracteres")
    private String description;

    @NotBlank(message = "La categoría no puede estar vacía")
    private Integer categoryId;

    @NotBlank(message = "El gestor del curso no puede estar vacío")
    private Integer managerId;

    @NotBlank(message = "El instructor del curso no puede estar vacío")
    private Integer instructorId;

    @NotBlank(message = "La fecha de publicación no puede estar vacía")
    private LocalDate publishDate;

    @NotBlank(message = "El precio no puede estar vacío")
    private BigDecimal price;

    @NotBlank(message = "La imagen no puede estar vacía")
    @Size(max = 255, message = "La URL de la imagen no puede superar los 255 caracteres")
    private String image;

    @NotBlank(message = "El estado no puede estar vacío")
    @Size(max = 50, message = "El estado no puede superar los 50 caracteres")
    private String status;

    public static CourseDTO fromEntity(Course entity) {
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());

        dto.setCategoryId(entity.getCategory().getId());
        dto.setManagerId(entity.getManager().getId());
        dto.setInstructorId(entity.getInstructor().getId());

        dto.setPublishDate(entity.getPublishDate());
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImage());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Course toEntity() {
        Course entity = new Course();
        entity.setId(this.id);
        entity.setTitle(this.title);
        entity.setDescription(this.description);

        CourseCategory category = new CourseCategory();
        category.setId(this.categoryId);
        entity.setCategory(category);

        User manager = new User();
        manager.setId(this.managerId);
        entity.setManager(manager);

        User instructor = new User();
        instructor.setId(this.instructorId);
        entity.setInstructor(instructor);

        entity.setPublishDate(this.publishDate);
        entity.setPrice(this.price);
        entity.setImage(this.image);
        entity.setStatus(this.status);
        return entity;
    }
}
