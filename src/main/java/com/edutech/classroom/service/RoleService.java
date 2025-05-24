package com.edutech.classroom.service;

import com.edutech.classroom.dto.RoleDTO;
import com.edutech.classroom.entity.Role;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RoleService {

    private RoleRepository roleRepository;

    public List<RoleDTO> findAll() {
        return roleRepository.findAll().stream().map(RoleDTO::fromEntity).toList();
    }

    public RoleDTO findById(Integer id) {
        return RoleDTO.fromEntity(roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado")));
    }

    public RoleDTO create(RoleDTO dto) {
        return RoleDTO.fromEntity(roleRepository.save(dto.toEntity()));
    }

    public RoleDTO update(Integer id,RoleDTO dto) {
        roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));
        Role entity = dto.toEntity();
        return RoleDTO.fromEntity(roleRepository.save(entity));
    }

    public void delete(Integer id) {
        roleRepository.delete(roleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Rol no encontrado")));
    }
}
