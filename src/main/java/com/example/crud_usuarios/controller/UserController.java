package com.example.crud_usuarios.controller;

import com.example.crud_usuarios.dto.UserDTO;
import com.example.crud_usuarios.dto.UserResponseDTO;
import com.example.crud_usuarios.mapper.UserMapper;
import com.example.crud_usuarios.model.User;
import com.example.crud_usuarios.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        User createdUser = userService.createUser(userDTO);
        UserResponseDTO response = userMapper.toResponseDTO(createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}