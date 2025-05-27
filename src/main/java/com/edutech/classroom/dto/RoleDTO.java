package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoleDTO {

    private Integer id;

    @NotNull(message = "El nombre del rol no puede estar vacío")
    @Size(max = 50, message = "El nombre del rol no puede superar los 50 caracteres")
    private String name;

    @NotNull(message = "La descripción del rol no puede estar vacía")
    @Size(max = 800, message = "La descripción del rol no puede superar los 800 caracteres")
    private String description;

    public static RoleDTO fromEntity(Role entity) {
        RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public Role toEntity() {
        Role entity = new Role();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setDescription(this.description);
        return entity;
    }
}
