package com.edutech.classroom.service;

import com.edutech.classroom.dto.QuizResponseDTO;
import com.edutech.classroom.entity.QuizResponse;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.QuizResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class QuizResponseService {
    private final QuizResponseRepository quizResponseRepository;

    public List<QuizResponseDTO> findAll() {
        return quizResponseRepository.findAll().stream().map(QuizResponseDTO::fromEntity).toList();
    }

    public QuizResponseDTO findById(Integer id) {
        return QuizResponseDTO.fromEntity(quizResponseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Respuesta no encontrada")));
    }

    public QuizResponseDTO create(QuizResponseDTO dto) {
        return QuizResponseDTO.fromEntity(quizResponseRepository.save(dto.toEntity()));
    }

    public QuizResponseDTO update(Integer id, QuizResponseDTO dto) {
        quizResponseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Respuesta no encontrada"));
        QuizResponse entity = dto.toEntity();
        return QuizResponseDTO.fromEntity(quizResponseRepository.save(entity));
    }

    public void delete(Integer id) {
        quizResponseRepository.delete(quizResponseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Respuesta no encontrada")));
    }
}
