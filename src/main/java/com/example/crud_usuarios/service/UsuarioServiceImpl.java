package com.example.crud_usuarios.service;

import com.example.crud_usuarios.dto.UsuarioDTO;
import com.example.crud_usuarios.model.Usuario;
import com.example.crud_usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<?> crearUsuario(UsuarioDTO usuarioDTO) {

        // Validar documento único
        Optional<Usuario> usuarioExistente = usuarioRepository.findByNumeroDocumento(usuarioDTO.getNumeroDocumento());
        if (usuarioExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Error: Ya existe un usuario con el mismo número de documento.");
        }

        // Crear y guardar usuario
        Usuario usuario = new Usuario();
        usuario.setPrimerNombre(usuarioDTO.getPrimerNombre());
        usuario.setSegundoNombre(usuarioDTO.getSegundoNombre());
        usuario.setApellidos(usuarioDTO.getApellidos());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setTipoDocumento(usuarioDTO.getTipoDocumento());
        usuario.setNumeroDocumento(usuarioDTO.getNumeroDocumento());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setCiudadResidencia(usuarioDTO.getCiudadResidencia());

        usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario creado exitosamente.");
    }
}
