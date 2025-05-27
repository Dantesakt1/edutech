package com.edutech.classroom.service;

import com.edutech.classroom.dto.CourseQuizQuestionDTO;
import com.edutech.classroom.entity.CourseQuizQuestion;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseQuizQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseQuizQuestionService {
    private final CourseQuizQuestionRepository courseQuizQuestionRepository;

    public List<CourseQuizQuestionDTO> findAll() {
        return courseQuizQuestionRepository.findAll().stream().map(CourseQuizQuestionDTO::fromEntity).toList();
    }

    public CourseQuizQuestionDTO findById(Integer id) {
        return CourseQuizQuestionDTO.fromEntity(courseQuizQuestionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada")));
    }

    public CourseQuizQuestionDTO create(CourseQuizQuestionDTO dto) {
        return CourseQuizQuestionDTO.fromEntity(courseQuizQuestionRepository.save(dto.toEntity()));
    }

    public CourseQuizQuestionDTO update(Integer id,CourseQuizQuestionDTO dto) {
        courseQuizQuestionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada"));
        CourseQuizQuestion entity = dto.toEntity();
        return CourseQuizQuestionDTO.fromEntity(courseQuizQuestionRepository.save(entity));
    }

    public void delete(Integer id) {
        courseQuizQuestionRepository.delete(courseQuizQuestionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Pregunta no encontrada")));
    }
}
