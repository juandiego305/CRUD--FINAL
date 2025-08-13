package com.example.crud_usuarios.service;

import com.example.crud_usuarios.dto.UserDTO;
import com.example.crud_usuarios.mapper.UserMapper;
import com.example.crud_usuarios.model.User;
import com.example.crud_usuarios.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<?> createUser(UserDTO userDTO) {
        Optional<User> usuarioExistente = userRepository.findBydocumentNumber(userDTO.getDocumentNumber());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("Ya existe un usuario con el mismo número de documento.");
        }

        User user = userMapper.toModel(userDTO);
        userRepository.save(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<?> updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        user.setFirstName(userDTO.getFirstName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName1(userDTO.getLastName1());
        user.setLastName2(userDTO.getLastName2());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setDocumentType(userDTO.getDocumentType());
        user.setDocumentNumber(userDTO.getDocumentNumber());
        user.setPhone(userDTO.getPhone());
        user.setCity(userDTO.getCity());

        userRepository.save(user);
        return ResponseEntity.ok(userMapper.toDTO(user));
    }
}
