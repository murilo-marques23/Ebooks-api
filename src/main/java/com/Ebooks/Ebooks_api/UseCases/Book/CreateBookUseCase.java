package com.Ebooks.Ebooks_api.UseCases.Book;

import com.Ebooks.Ebooks_api.Entity.Book;
import com.Ebooks.Ebooks_api.repositories.BookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateBookUseCase {
    private final BookRepository bookRepository;

    public Book execute(Book book){
        return bookRepository.save(book);
    }
}
