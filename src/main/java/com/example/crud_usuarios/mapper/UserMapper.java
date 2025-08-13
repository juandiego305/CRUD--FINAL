package com.example.crud_usuarios.mapper;


import com.example.crud_usuarios.dto.UsuarioDTO;
import com.example.crud_usuarios.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    @Mapping(target = "primerNombre", source = "primerNombre")
    Usuario toModel(UsuarioDTO usuarioDTO);
}
