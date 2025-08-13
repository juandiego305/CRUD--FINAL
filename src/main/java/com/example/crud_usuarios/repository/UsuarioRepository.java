package com.example.crud_usuarios.repository;

import com.example.crud_usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNumeroDocumento(String numeroDocumento);
}
