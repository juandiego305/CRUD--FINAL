package com.example.crud_usuarios.mapper;


import com.example.crud_usuarios.dto.UserDTO;
import com.example.crud_usuarios.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toModel(UserDTO userDTO);


    UserDTO toDTO(User user);
}