package com.edutech.classroom.controller;

import com.edutech.classroom.dto.CourseQuizQuestionDTO;
import com.edutech.classroom.service.CourseQuizQuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-quiz-questions")
@RequiredArgsConstructor

public class CourseQuizQuestionController {
    private final CourseQuizQuestionService courseQuizQuestionService;

    @GetMapping
    public ResponseEntity<List<CourseQuizQuestionDTO>> findAll() {
        return ResponseEntity.ok(courseQuizQuestionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseQuizQuestionDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(courseQuizQuestionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CourseQuizQuestionDTO> create(@RequestBody @Valid CourseQuizQuestionDTO dto) {
        return ResponseEntity.ok(courseQuizQuestionService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseQuizQuestionDTO> update(@PathVariable Integer id, @Valid @RequestBody CourseQuizQuestionDTO dto) {
        return ResponseEntity.ok(courseQuizQuestionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        courseQuizQuestionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
