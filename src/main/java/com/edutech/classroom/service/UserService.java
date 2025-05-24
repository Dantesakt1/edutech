package com.edutech.classroom.service;

import com.edutech.classroom.dto.UserDTO;
import com.edutech.classroom.entity.User;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTO::fromEntity).toList();
    }

    public UserDTO findById(Integer id) {
        return UserDTO.fromEntity(userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado")));
    }

    public UserDTO create(UserDTO dto) {
        return UserDTO.fromEntity(userRepository.save(dto.toEntity()));
    }

    public UserDTO update(Integer id,UserDTO dto) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        User entity = dto.toEntity();
        return UserDTO.fromEntity(userRepository.save(entity));
    }

    public void delete(Integer id) {
        userRepository.delete(userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Usuario no encontrado")));
    }
}
