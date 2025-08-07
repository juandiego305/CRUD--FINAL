package com.example.crud_usuarios.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String primerNombre;
    private String segundoNombre;
    private String apellidos;
    private String direccion;
    private String correo;
    private String tipoDocumento;
    private String numeroDocumento;
    private String telefono;
    private String ciudadResidencia;
}
