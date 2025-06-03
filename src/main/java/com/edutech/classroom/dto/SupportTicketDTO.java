package com.edutech.classroom.dto;

import com.edutech.classroom.entity.SupportTicket;
import com.edutech.classroom.entity.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data

public class SupportTicketDTO {
    private Integer id;

    @NotNull(message = "El usuario no puede estar vacío")
    private Integer userId;

    private Integer supportId;

    @NotBlank(message = "El asunto no puede estar vacío")
    @Size(max = 200, message = "El asunto no puede superar los 200 caracteres")
    private String subject;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 800, message = "La descripción no puede superar los 800 caracteres")
    private String description;

    @NotBlank(message = "El estado no puede estar vacío")
    @Size(max = 20, message = "El estado no puede superar los 20 caracteres")
    private String status;

    @NotNull(message = "La fecha de creación no puede estar vacía")
    private Instant createdAt;

    private Instant closedAt;

    public static SupportTicketDTO fromEntity(SupportTicket entity){
        SupportTicketDTO dto = new SupportTicketDTO();
        dto.setId(entity.getId());

        dto.setUserId(entity.getUser().getId());
        dto.setSupportId(entity.getSupportUser().getId());

        dto.setSubject(entity.getSubject());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setClosedAt(entity.getClosedAt());
        return dto;
    }

    public SupportTicket toEntity(){
        SupportTicket entity = new SupportTicket();
        entity.setId(this.id);

        User user = new User();
        user.setId(this.userId);
        entity.setUser(user);

        User support = new User();
        support.setId(this.supportId);
        entity.setSupportUser(support);

        entity.setSubject(this.subject);
        entity.setDescription(this.description);
        entity.setStatus(this.status);
        entity.setCreatedAt(this.createdAt);
        entity.setClosedAt(this.closedAt);
        return entity;
    }
}
