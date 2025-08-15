package com.example.crud_usuarios.service;

import com.example.crud_usuarios.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import java.util.Map;

public interface UserService {
    ResponseEntity<Map<String, String>> createUser(UserDTO userDTO);
    ResponseEntity<UserDTO> updateUser(Long id, UserDTO userDTO);
}
