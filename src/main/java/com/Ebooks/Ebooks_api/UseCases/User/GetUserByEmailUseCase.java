package com.Ebooks.Ebooks_api.UseCases.User;

import com.Ebooks.Ebooks_api.Entity.User;
import com.Ebooks.Ebooks_api.exception.Http.NotFoundException;
import com.Ebooks.Ebooks_api.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetUserByEmailUseCase {
        private final UserRepository userRepository;

        public User execute(String email){
            Optional<User> user =this.userRepository.findByEmail(email);

            if(user.isEmpty()){
                throw new NotFoundException("Não Foi Possivel Encontrar o Usuario");
            }
            return user.get();
        }
}
