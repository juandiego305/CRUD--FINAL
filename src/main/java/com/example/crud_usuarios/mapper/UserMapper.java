package com.example.crud_usuarios.mapper;

import com.example.crud_usuarios.dto.UserDTO;
import com.example.crud_usuarios.dto.UserResponseDTO;
import com.example.crud_usuarios.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "lastName1", target = "lastName1")
    @Mapping(source = "lastName2", target = "lastName2")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "documentType", target = "documentType")
    @Mapping(source = "documentNumber", target = "documentNumber")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "city", target = "city")
    User toModel(UserDTO userDTO);

    UserDTO toDTO(User user);

    UserResponseDTO toResponseDTO(User user);
}