package com.edutech.classroom.service;

import com.edutech.classroom.dto.CourseQuizDTO;
import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseQuizService {

    private final CourseQuizRepository courseQuizRepository;

    public List<CourseQuizDTO> findAll() {
        return courseQuizRepository.findAll().stream().map(CourseQuizDTO::fromEntity).toList();
    }

    public CourseQuizDTO findById(Integer id) {
        return CourseQuizDTO.fromEntity(courseQuizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz no encontrado")));
    }

    public CourseQuizDTO create(CourseQuizDTO dto) {
        return CourseQuizDTO.fromEntity(courseQuizRepository.save(dto.toEntity()));
    }

    public CourseQuizDTO update(Integer id,CourseQuizDTO dto) {
        courseQuizRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Quiz no encontrado"));
        CourseQuiz entity = dto.toEntity();
        return CourseQuizDTO.fromEntity(courseQuizRepository.save(entity));
    }

    public void delete(Integer id) {
        courseQuizRepository.delete(courseQuizRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Quiz no encontrado")));
    }
}
