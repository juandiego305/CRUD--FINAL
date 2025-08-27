package com.example.crud_usuarios.service;

import com.example.crud_usuarios.dto.UserDTO;
import com.example.crud_usuarios.mapper.UserMapper;
import com.example.crud_usuarios.model.User;
import com.example.crud_usuarios.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(UserDTO userDTO) {
        System.out.println("[DEBUG] UserDTO received: " + userDTO);

        if (userExists(userDTO.getDocumentNumber())) {
            throw new RuntimeException("Usuario Existente.");
        }

        User user = userMapper.toModel(userDTO);
        System.out.println("[DEBUG] Mapped User: " + user);

        if (!validateUser(user)) {
            throw new RuntimeException("Datos de usuario inválidos.");
        }

        return userRepository.save(user);
    }

    @Override
    public boolean userExists(String documentNumber) {
        Optional<User> existingUser = userRepository.findBydocumentNumber(documentNumber);
        return existingUser.isPresent();
    }

    @Override
    public boolean validateUser(User user) {
        return user != null && Stream.of(
                user.getDocumentNumber(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName1(),
                user.getLastName2(),
                user.getDocumentType(),
                user.getPhone()
        ).allMatch(field -> field != null && !field.trim().isEmpty());
    }
}
