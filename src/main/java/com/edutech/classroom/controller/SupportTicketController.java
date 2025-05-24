package com.edutech.classroom.controller;

import com.edutech.classroom.dto.SupportTicketDTO;
import com.edutech.classroom.service.SupportTicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/support-tickets")
@RequiredArgsConstructor

public class SupportTicketController {
    private final SupportTicketService supportTicketService;

    @GetMapping
    public ResponseEntity<List<SupportTicketDTO>> findAll() {
        return ResponseEntity.ok(supportTicketService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportTicketDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(supportTicketService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SupportTicketDTO> create(@RequestBody @Valid SupportTicketDTO dto) {
        return ResponseEntity.ok(supportTicketService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupportTicketDTO> update(@PathVariable Integer id, @Valid @RequestBody SupportTicketDTO dto) {
        return ResponseEntity.ok(supportTicketService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        supportTicketService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
