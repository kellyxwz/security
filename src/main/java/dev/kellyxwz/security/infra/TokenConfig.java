package dev.kellyxwz.security.infra;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import dev.kellyxwz.security.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
public class TokenConfig {

    private Algorithm algorithm ;

    public TokenConfig(@Value("${api.security.token.secret}") String secret) {

        this.algorithm = Algorithm.HMAC256(secret);

    }

    public String generateToken(User user){
        try {
            return JWT.create()
                    .withIssuer("auth-api")
                    .withClaim("userId", user.getId())
                    .withSubject(user.getEmail())
                    .withExpiresAt(getExpirationData())
                    .withIssuedAt(Instant.now())
                    .sign(algorithm);
        }catch (JWTCreationException e){
            throw new RuntimeException("Erro ao gerar token", e);
        }
    }

    private String validateToken(String token){
        try {
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException e){
            return "" ;
        }

    }

    private Instant getExpirationData(){
        return Instant.now().plus(Duration.ofHours(2));
    }

}
