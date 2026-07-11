package dev.kellyxwz.security.controller;

import dev.kellyxwz.security.dto.reponse.LoginResponse;
import dev.kellyxwz.security.dto.reponse.RegisterUserResponse;
import dev.kellyxwz.security.dto.request.LoginRequest;
import dev.kellyxwz.security.dto.request.RegisterUserRequest;
import dev.kellyxwz.security.entity.User;
import dev.kellyxwz.security.entity.UserRoles;
import dev.kellyxwz.security.infra.CustomUser;
import dev.kellyxwz.security.infra.TokenConfig;
import dev.kellyxwz.security.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenConfig tokenConfig) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest userLogin){
        UsernamePasswordAuthenticationToken userPass = new UsernamePasswordAuthenticationToken(userLogin.email(), userLogin.password());
        Authentication authentication = authenticationManager.authenticate(userPass);

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        String token = tokenConfig.generateToken(customUser.user());

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest userRegister){
        User user = new User();
        user.setName(userRegister.name());
        user.setEmail(userRegister.email());
        user.setPassword(passwordEncoder.encode(userRegister.password()));
        user.setRole(UserRoles.USER);

        User newUser = userRepository.save(user);

        return ResponseEntity.ok(new RegisterUserResponse(newUser));
    }

}
