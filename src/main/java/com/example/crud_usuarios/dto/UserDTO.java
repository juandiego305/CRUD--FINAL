package com.example.crud_usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserDTO {

    @NotBlank(message = "El primer nombre es obligatorio")
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$", message = "Error 401 caracteres invalidos")
    private String firstName;

    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]*$", message = "Error 401 caracteres invalidos")
    private String middleName;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$", message = "Error 401 caracteres invalidos")
    private String lastName1;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$", message = "Error 401 caracteres invalidos")
    private String lastName2;

    private String address;

    @Email(message = "Correo electrónico no válido")
    private String email;

    @NotBlank(message = "El tipo de documento es obligatorio")
    @Pattern(regexp = "^(CC|TI|CE|PAS)$", message = "Tipo de documento inválido")
    private String documentType;

    @NotBlank(message = "El número de documento es obligatorio")
    @Pattern(regexp = "^[0-9]+$", message = "El número de documento debe contener solo números")
    private String documentNumber;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^\\d{10}$", message = "El teléfono debe tener exactamente 10 dígitos")
    private String phone;

    private String city;
}
