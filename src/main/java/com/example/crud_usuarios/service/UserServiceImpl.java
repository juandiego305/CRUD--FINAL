package com.example.crud_usuarios.service;

import com.example.crud_usuarios.dto.UserDTO;
import com.example.crud_usuarios.mapper.UserMapper;
import com.example.crud_usuarios.model.User;
import com.example.crud_usuarios.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

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
        System.out.println("[DEBUG] Validating user: " + user);

        if (user == null) {
            System.out.println("[DEBUG] User is null");
            return false;
        }

        if (user.getDocumentNumber() == null || user.getDocumentNumber().trim().isEmpty()) {
            System.out.println("[DEBUG] DocumentNumber is null or empty: " + user.getDocumentNumber());
            return false;
        }

        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            System.out.println("[DEBUG] Email is null or empty: " + user.getEmail());
            return false;
        }

        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
            System.out.println("[DEBUG] FirstName is null or empty: " + user.getFirstName());
            return false;
        }

        if (user.getLastName1() == null || user.getLastName1().trim().isEmpty()) {
            System.out.println("[DEBUG] LastName1 is null or empty: " + user.getLastName1());
            return false;
        }

        if (user.getLastName2() == null || user.getLastName2().trim().isEmpty()) {
            System.out.println("[DEBUG] LastName2 is null or empty: " + user.getLastName2());
            return false;
        }

        if (user.getDocumentType() == null || user.getDocumentType().trim().isEmpty()) {
            System.out.println("[DEBUG] DocumentType is null or empty: " + user.getDocumentType());
            return false;
        }

        if (user.getPhone() == null || user.getPhone().trim().isEmpty()) {
            System.out.println("[DEBUG] Phone is null or empty: " + user.getPhone());
            return false;
        }

        System.out.println("[DEBUG] User validation passed");
        return true;
    }
}
