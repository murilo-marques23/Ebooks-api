package com.Ebooks.Ebooks_api.repositories;

import com.Ebooks.Ebooks_api.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
