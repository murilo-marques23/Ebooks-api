package com.Ebooks.Ebooks_api.UseCases.User;

import com.Ebooks.Ebooks_api.Entity.User;
import com.Ebooks.Ebooks_api.Settings.PasswordEncoderSettings;
import com.Ebooks.Ebooks_api.exception.Http.HttpException;
import com.Ebooks.Ebooks_api.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User execute(User user){
        boolean isEmailRegistered = userRepository.existsByEmail(user.getEmail());
        if (
                isEmailRegistered
        ){throw new HttpException("Usuario Ja Existente", HttpStatus.UNPROCESSABLE_ENTITY);}

        String hashedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return this.userRepository.save(user);
    }
}
