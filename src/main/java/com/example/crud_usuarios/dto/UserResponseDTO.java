package com.example.crud_usuarios.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName1;
    private String lastName2;
    private String address;
    private String email;
    private String documentType;
    private String documentNumber;
    private String phone;
    private String city;
}
