package dev.kellyxwz.security.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record LoginRequest(

        @NotEmpty(message = "nome é obrigatório")
        String name,
        @NotEmpty(message = "email é obrigatório")
        String email,
        @NotEmpty(message = "senha é obrigatório" )
        String password
) {


}
