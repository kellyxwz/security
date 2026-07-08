package dev.kellyxwz.security.controller;

import dev.kellyxwz.security.dto.reponse.LoginResponse;
import dev.kellyxwz.security.dto.reponse.RegisterUserResponse;
import dev.kellyxwz.security.dto.request.LoginRequest;
import dev.kellyxwz.security.dto.request.RegisterUserRequest;
import dev.kellyxwz.security.entity.User;
import dev.kellyxwz.security.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest userLogin){
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest userRegister){
        User user = new User();
        user.setName(userRegister.name());
        user.setEmail(userRegister.email());
        user.setPassword(userRegister.password());

        User newUser = userRepository.save(user);

        return ResponseEntity.ok(new RegisterUserResponse(newUser));
    }

}
