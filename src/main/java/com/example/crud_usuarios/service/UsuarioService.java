package com.example.crud_usuarios.service;

import com.example.crud_usuarios.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;


public interface UsuarioService {
    ResponseEntity<?> crearUsuario(UsuarioDTO usuarioDTO);
    ResponseEntity<?> actualizarUsuario(Long id, UsuarioDTO usuarioDTO);

}
