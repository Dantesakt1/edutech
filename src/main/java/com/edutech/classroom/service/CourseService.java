package com.edutech.classroom.service;

import com.edutech.classroom.dto.CourseDTO;
import com.edutech.classroom.entity.Course;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseService {
    private final CourseRepository courseRepository;

    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(CourseDTO::fromEntity).toList();
    }

    public CourseDTO findById(Integer id) {
        return CourseDTO.fromEntity(courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado")));
    }

    public CourseDTO create(CourseDTO dto) {
        return CourseDTO.fromEntity(courseRepository.save(dto.toEntity()));
    }

    public CourseDTO update(Integer id,CourseDTO dto) {
        courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        Course entity = dto.toEntity();
        return CourseDTO.fromEntity(courseRepository.save(entity));
    }

    public void delete(Integer id) {
        courseRepository.delete(courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Curso no encontrado")));
    }
}
