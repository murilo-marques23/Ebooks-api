package com.Ebooks.Ebooks_api.repositories;

import com.Ebooks.Ebooks_api.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail (String email);
}
