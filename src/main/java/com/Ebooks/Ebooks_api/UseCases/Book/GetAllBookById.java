package com.Ebooks.Ebooks_api.UseCases.Book;

import com.Ebooks.Ebooks_api.Entity.Book;
import com.Ebooks.Ebooks_api.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllBookById {
    private final BookRepository repository;

    public List<Book> execute(){
        return repository.findAll();
    }
}
