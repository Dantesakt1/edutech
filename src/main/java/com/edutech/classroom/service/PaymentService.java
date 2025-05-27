package com.edutech.classroom.service;

import com.edutech.classroom.dto.PaymentDTO;
import com.edutech.classroom.entity.Payment;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PaymentService {

    private final PaymentRepository paymentRepository;

    public List<PaymentDTO> findAll() {
        return paymentRepository.findAll().stream().map(PaymentDTO::fromEntity).toList();
    }

    public PaymentDTO findById(Integer id) {
        return PaymentDTO.fromEntity(paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado")));
    }

    public PaymentDTO create(PaymentDTO dto) {
        return PaymentDTO.fromEntity(paymentRepository.save(dto.toEntity()));
    }

    public PaymentDTO update(Integer id,PaymentDTO dto) {
        paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
        Payment entity = dto.toEntity();
        return PaymentDTO.fromEntity(paymentRepository.save(entity));
    }

    public void delete(Integer id) {
        paymentRepository.delete(paymentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Pago no encontrado")));
    }
}
