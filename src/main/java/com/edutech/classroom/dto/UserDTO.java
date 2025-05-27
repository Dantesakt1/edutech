package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Role;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class UserDTO {

    private Integer id;

    @NotNull(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String firstName;

    @NotNull(message = "El apellido no puede estar vacío")
    @Size(max = 100, message = "El apellido no puede superar los 100 caracteres")
    private String lastName;

    @NotNull(message = "El correo electrónico no puede estar vacío")
    @Email(message = "Debe ser un correo electrónico válido")
    @Size(max = 255, message = "El correo electrónico no puede superar los 255 caracteres")
    private String email;

    @NotNull(message = "La contraseña no puede estar vacía")
    @Size(max = 255, message = "La contraseña no puede superar los 255 caracteres")
    private String passwordHash;

    @NotNull(message = "El rol no puede estar vacío")
    private Integer roleId;

    @NotNull(message = "El estado activo no puede estar vacío")
    private Boolean isActive;

    private Instant createdAt;

    private Instant updatedAt;

    public static UserDTO fromEntity(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPasswordHash(entity.getPasswordHash());

        dto.setRoleId(entity.getRole().getId());

        dto.setIsActive(entity.getIsActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public User toEntity() {
        User entity = new User();
        entity.setId(this.id);
        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setEmail(this.email);
        entity.setPasswordHash(this.passwordHash);

        Role role = new Role();
        role.setId(this.roleId);
        entity.setRole(role);

        entity.setIsActive(this.isActive);
        entity.setCreatedAt(this.createdAt);
        entity.setUpdatedAt(this.updatedAt);
        return entity;
    }
}
