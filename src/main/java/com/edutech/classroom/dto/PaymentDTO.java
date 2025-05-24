package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Payment;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PaymentDTO {
    private Integer id;

    @NotNull(message = "El usuario no puede estar vacío")
    private Integer userId;

    @NotNull(message = "El monto no puede estar vacío")
    private BigDecimal amount;

    @NotNull(message = "La fecha de pago no puede estar vacía")
    private Instant paymentDate;

    @NotNull(message = "El método de pago no puede estar vacío")
    @Size(max = 100, message = "El método de pago no puede superar los 100 caracteres")
    private String paymentMethod;

    @NotNull(message = "La institución de pago no puede estar vacía")
    @Size(max = 200, message = "La institución no puede superar los 200 caracteres")
    private String paymentInstitution;

    @NotNull(message = "El ID de transacción no puede estar vacío")
    @Size(max = 200, message = "El ID de transacción no puede superar los 200 caracteres")
    private String transactionId;

    @NotNull(message = "El estado no puede estar vacío")
    @Size(max = 20, message = "El estado no puede superar los 20 caracteres")
    private String status;

    public static PaymentDTO fromEntity(Payment entity) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUser().getId());
        dto.setAmount(entity.getAmount());
        dto.setPaymentDate(entity.getPaymentDate());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setPaymentInstitution(entity.getPaymentInstitution());
        dto.setTransactionId(entity.getTransactionId());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Payment toEntity() {
        Payment entity = new Payment();
        entity.setId(this.id);

        User user = new User();
        user.setId(this.userId);
        entity.setUser(user);

        entity.setAmount(this.amount);
        entity.setPaymentDate(this.paymentDate);
        entity.setPaymentMethod(this.paymentMethod);
        entity.setPaymentInstitution(this.paymentInstitution);
        entity.setTransactionId(this.transactionId);
        entity.setStatus(this.status);
        return entity;
    }
}
