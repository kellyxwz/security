package dev.kellyxwz.security.dto.reponse;

import dev.kellyxwz.security.entity.User;

public record RegisterUserResponse(
        String name,
        String email
) {
    public RegisterUserResponse(User user) {
        this(
                user.getName(),
                user.getEmail()
        );
    }
}
