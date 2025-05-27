package com.edutech.classroom.service;

import com.edutech.classroom.dto.StudentMarkDTO;
import com.edutech.classroom.entity.StudentMark;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.StudentMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentMarkService {
    private final StudentMarkRepository studentMarkRepository;

    public List<StudentMarkDTO> findAll() {
        return studentMarkRepository.findAll().stream().map(StudentMarkDTO::fromEntity).toList();
    }

    public StudentMarkDTO findById(Integer id) {
        return StudentMarkDTO.fromEntity(studentMarkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota no encontrada")));
    }

    public StudentMarkDTO create(StudentMarkDTO dto) {
        return StudentMarkDTO.fromEntity(studentMarkRepository.save(dto.toEntity()));
    }

    public StudentMarkDTO update(Integer id,StudentMarkDTO dto) {
        studentMarkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nota no encontrada"));
        StudentMark entity = dto.toEntity();
        return StudentMarkDTO.fromEntity(studentMarkRepository.save(entity));
    }

    public void delete(Integer id) {
        studentMarkRepository.delete(studentMarkRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Nota no encontrada")));
    }
}
