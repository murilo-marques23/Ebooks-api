package com.Ebooks.Ebooks_api.UseCases.User;


import com.Ebooks.Ebooks_api.Entity.User;
import com.Ebooks.Ebooks_api.exception.Http.NotFoundException;
import com.Ebooks.Ebooks_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetUserByIdUseCase {
    private final UserRepository userRepository;

    public User execute(Long id){
        return this.userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nenhum usuário encontrado"));
    }
}