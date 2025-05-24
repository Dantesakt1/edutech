package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class CourseCategoryDTO {

    private Integer id;
    @NotNull(message = "El nombre de la categoría no puede estar vacío")
    @Size(max = 100, message = "No puede superar los 100 caracteres")
    private String name;
    @NotNull(message = "La descripción de la categoría no puede estar vacía")
    @Size(max = 800, message = "No puede superar los 800 caracteres")
    private String description;

    public static CourseCategoryDTO fromEntity(CourseCategory entity) {
        CourseCategoryDTO dto = new CourseCategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public CourseCategory toEntity() {
        CourseCategory entity = new CourseCategory();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setDescription(this.description);
        return entity;
    }
}
