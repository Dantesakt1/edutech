package com.edutech.classroom.controller;

import com.edutech.classroom.dto.CourseContentDTO;
import com.edutech.classroom.service.CourseContentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-contents")
@RequiredArgsConstructor

public class CourseContentController {
    private final CourseContentService courseContentService;

    @GetMapping
    public ResponseEntity<List<CourseContentDTO>> findAll() {
        return ResponseEntity.ok(courseContentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseContentDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(courseContentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CourseContentDTO> create(@RequestBody @Valid CourseContentDTO dto) {
        return ResponseEntity.ok(courseContentService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseContentDTO> update(@PathVariable Integer id, @Valid @RequestBody CourseContentDTO dto) {
        return ResponseEntity.ok(courseContentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        courseContentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
