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
        if (userExists(userDTO.getDocumentNumber())) {
            throw new RuntimeException("Usuario Existente.");
        }

        User user = userMapper.toModel(userDTO);

        if (!validateUser(user)) {
            throw new RuntimeException("Datos de usuario inválidos.");
        }

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserDTO userDTO) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (!existingUserOpt.isPresent()) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }

        User existingUser = existingUserOpt.get();

        if (!existingUser.getDocumentNumber().equals(userDTO.getDocumentNumber()) &&
                userExists(userDTO.getDocumentNumber())) {
            throw new RuntimeException("El número de documento ya existe en otro usuario.");
        }

        User userToUpdate = userMapper.toModel(userDTO);
        userToUpdate.setId(id);

        if (!validateUser(userToUpdate)) {
            throw new RuntimeException("Datos de usuario inválidos.");
        }

        return userRepository.save(userToUpdate);
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