package com.Ebooks.Ebooks_api.UseCases.User;


import com.Ebooks.Ebooks_api.Dto.Output.JwtLoginDto;
import com.Ebooks.Ebooks_api.Entity.User;
import com.Ebooks.Ebooks_api.exception.Http.HttpException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class LoginUserUseCase {
    private final CreateUserUseCase createUserUseCase;
    private final PasswordEncoder passwordEncoder;
    private final Algorithm algorithm;
    private final GetUserByEmailUseCase getUserByEmailUseCase;

    @Value("${app.jwt.expiration}")
    private  Long expiration;

    public JwtLoginDto execute(String email, String password){
        User user = this.getUserByEmailUseCase.execute(email);

        if(!this.passwordEncoder.matches(password, user.getPassword())) {
            throw new HttpException("Senha Incorreta", HttpStatus.NOT_FOUND);
        }
        Instant expiresIn = Instant.now().plus(Duration.ofHours(this.expiration));
        String token = JWT.create()
                .withSubject(user.getId().toString())
                .withExpiresAt(expiresIn)
                .sign(this.algorithm);

    return  new JwtLoginDto(token, expiresIn);
    }


}
