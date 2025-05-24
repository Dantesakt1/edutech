package com.edutech.classroom.service;

import com.edutech.classroom.dto.SupportTicketDTO;
import com.edutech.classroom.entity.SupportTicket;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.SupportTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class SupportTicketService {
    private final SupportTicketRepository supportTicketRepository;

    public List<SupportTicketDTO> findAll() {
        return supportTicketRepository.findAll().stream().map(SupportTicketDTO::fromEntity).toList();
    }

    public SupportTicketDTO findById(Integer id) {
        return SupportTicketDTO.fromEntity(supportTicketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado")));
    }

    public SupportTicketDTO create(SupportTicketDTO dto) {
        return SupportTicketDTO.fromEntity(supportTicketRepository.save(dto.toEntity()));
    }

    public SupportTicketDTO update(Integer id,SupportTicketDTO dto) {
        supportTicketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado"));
        SupportTicket entity = dto.toEntity();
        return SupportTicketDTO.fromEntity(supportTicketRepository.save(entity));
    }

    public void delete(Integer id) {
        supportTicketRepository.delete(supportTicketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket no encontrado")));
    }
}
