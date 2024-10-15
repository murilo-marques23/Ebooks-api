package com.Ebooks.Ebooks_api.UseCases.User;


import com.auth0.jwt.algorithms.Algorithm;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUserUseCase {
    private final CreateUserUseCase createUserUseCase;
    private final PasswordEncoder passwordEncoder;
    private final Algorithm algorithm;

    @Value("${app.jwt.expiration}")
    private Long expiration;


}
