package dev.kellyxwz.security.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest (
        @NotEmpty(message = "nome é obrigatório")
        String name,
        @NotEmpty(message = "email é obrigatório")
        String email,
        @NotEmpty(message = "senha é obrigatório" )
        String password
){
}
