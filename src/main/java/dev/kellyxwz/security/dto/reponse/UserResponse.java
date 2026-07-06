package dev.kellyxwz.security.dto.reponse;

import dev.kellyxwz.security.entity.User;

public record UserResponse (
        Long id,
        String name,
        String email
) {

    public UserResponse (User user){
        this(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
