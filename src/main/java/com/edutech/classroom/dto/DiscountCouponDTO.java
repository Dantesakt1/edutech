package com.edutech.classroom.dto;

import com.edutech.classroom.entity.DiscountCoupon;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data

public class DiscountCouponDTO {
    private Integer id;

    @NotBlank(message = "El código no puede estar vacío")
    @Size(max = 50, message = "El código no puede superar los 50 caracteres")
    private String code;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 800, message = "La descripción no puede superar los 800 caracteres")
    private String description;

    @NotBlank(message = "El porcentaje de descuento no puede estar vacío")
    private BigDecimal discountPercentage;

    @NotBlank(message = "La fecha de inicio no puede estar vacía")
    private LocalDate validFrom;

    @NotBlank(message = "La fecha de término no puede estar vacía")
    private LocalDate validUntil;

    @NotBlank(message = "El estado de activación no puede estar vacío")
    private Boolean isActive;

    public static DiscountCouponDTO fromEntity(DiscountCoupon entity) {
        DiscountCouponDTO dto = new DiscountCouponDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        dto.setDiscountPercentage(entity.getDiscountPercentage());
        dto.setValidFrom(entity.getValidFrom());
        dto.setValidUntil(entity.getValidUntil());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }

    public DiscountCoupon toEntity() {
        DiscountCoupon entity = new DiscountCoupon();
        entity.setId(this.id);
        entity.setCode(this.code);
        entity.setDescription(this.description);
        entity.setDiscountPercentage(this.discountPercentage);
        entity.setValidFrom(this.validFrom);
        entity.setValidUntil(this.validUntil);
        entity.setIsActive(this.isActive);
        return entity;
    }
}
