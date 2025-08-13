package com.example.crud_usuarios.service;

import com.example.crud_usuarios.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> createUser(UserDTO userDTO);
    ResponseEntity<?> updateUser(Long id, UserDTO userDTO);
}
