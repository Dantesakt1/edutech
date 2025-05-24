package com.edutech.classroom.controller;

import com.edutech.classroom.dto.QuizResponseDTO;
import com.edutech.classroom.service.QuizResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz-responses")
@RequiredArgsConstructor

public class QuizResponseController {
    private final QuizResponseService quizResponseService;

    @GetMapping
    public ResponseEntity<List<QuizResponseDTO>> findAll() {
        return ResponseEntity.ok(quizResponseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(quizResponseService.findById(id));
    }

    @PostMapping
    public ResponseEntity<QuizResponseDTO> create(@RequestBody @Valid QuizResponseDTO dto) {
        return ResponseEntity.ok(quizResponseService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> update(@PathVariable Integer id, @Valid @RequestBody QuizResponseDTO dto) {
        return ResponseEntity.ok(quizResponseService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        quizResponseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
