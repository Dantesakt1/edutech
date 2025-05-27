package com.edutech.classroom.service;

import com.edutech.classroom.dto.EnrollmentDTO;
import com.edutech.classroom.entity.Enrollment;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public List<EnrollmentDTO> findAll() {
        return enrollmentRepository.findAll().stream().map(EnrollmentDTO::fromEntity).toList();
    }

    public EnrollmentDTO findById(Integer id) {
        return EnrollmentDTO.fromEntity(enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inscripción no encontrada")));
    }

    public EnrollmentDTO create(EnrollmentDTO dto) {
        return EnrollmentDTO.fromEntity(enrollmentRepository.save(dto.toEntity()));
    }

    public EnrollmentDTO update(Integer id,EnrollmentDTO dto) {
        enrollmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Inscripción no encontrada"));
        Enrollment entity = dto.toEntity();
        return EnrollmentDTO.fromEntity(enrollmentRepository.save(entity));
    }

    public void delete(Integer id) {
        enrollmentRepository.delete(enrollmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Inscripción no encontrada")));
    }
}
