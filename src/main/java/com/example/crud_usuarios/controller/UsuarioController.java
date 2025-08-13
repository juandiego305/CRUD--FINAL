package com.example.crud_usuarios.controller;

import jakarta.validation.Valid;
import com.example.crud_usuarios.dto.UsuarioDTO;
import com.example.crud_usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final  UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errores = new StringBuilder();
            result.getFieldErrors().forEach(error ->
                    errores.append("Campo '").append(error.getField())
                            .append("': ").append(error.getDefaultMessage()).append(". ")
            );
            return ResponseEntity.badRequest().body(errores.toString());
        }

        return usuarioService.crearUsuario(usuarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Long id,
                                               @Valid @RequestBody UsuarioDTO usuarioDTO,
                                               BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errores = new StringBuilder();
            result.getFieldErrors().forEach(error ->
                    errores.append("Campo '").append(error.getField())
                            .append("': ").append(error.getDefaultMessage()).append(". ")
            );
            return ResponseEntity.badRequest().body(errores.toString());
        }

        return usuarioService.actualizarUsuario(id, usuarioDTO);
    }
    }