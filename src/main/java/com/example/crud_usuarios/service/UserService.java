package com.example.crud_usuarios.service;

import com.example.crud_usuarios.dto.UserDTO;
import com.example.crud_usuarios.model.User;

public interface UserService {
    User createUser(UserDTO userDTO);

    User updateUser(Long id, UserDTO userDTO);

    boolean userExists(String documentNumber);

    boolean validateUser(User user);
}
