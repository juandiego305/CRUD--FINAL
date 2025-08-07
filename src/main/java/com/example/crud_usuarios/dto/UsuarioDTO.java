package com.example.crud_usuarios.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UsuarioDTO {

    @NotBlank(message = "El primer nombre es obligatorio")
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$", message = "El primer nombre no debe contener números")
    private String primerNombre;

    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]*$", message = "El segundo nombre no debe contener números")
    private String segundoNombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$", message = "Los apellidos no deben contener números")
    private String apellidos;

    private String direccion;

    @Email(message = "Correo electrónico no válido")
    private String correo;

    @NotBlank(message = "El tipo de documento es obligatorio")
    @Pattern(regexp = "^(CC|TI|CE|PAS)$", message = "Tipo de documento inválido (solo: CC, TI, CE, PAS)")
    private String tipoDocumento;

    @NotBlank(message = "El número de documento es obligatorio")
    private String numeroDocumento;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^\\d{10}$", message = "El teléfono debe tener exactamente 10 dígitos numéricos")
    private String telefono;

    private String ciudadResidencia;
}
