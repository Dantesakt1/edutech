package com.edutech.classroom.service;

import com.edutech.classroom.dto.CourseCommentDTO;
import com.edutech.classroom.entity.CourseComment;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseCommentService {
    private final CourseCommentRepository courseCommentRepository;

    public List<CourseCommentDTO> findAll() {
        return courseCommentRepository.findAll().stream().map(CourseCommentDTO::fromEntity).toList();
    }

    public CourseCommentDTO findById(Integer id) {
        return CourseCommentDTO.fromEntity(courseCommentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado")));
    }

    public CourseCommentDTO create(CourseCommentDTO dto) {
        return CourseCommentDTO.fromEntity(courseCommentRepository.save(dto.toEntity()));
    }

    public CourseCommentDTO update(Integer id,CourseCommentDTO dto) {
        courseCommentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado"));
        CourseComment entity = dto.toEntity();
        return CourseCommentDTO.fromEntity(courseCommentRepository.save(entity));
    }

    public void delete(Integer id) {
        courseCommentRepository.delete(courseCommentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comentario no encontrado")));
    }
}
