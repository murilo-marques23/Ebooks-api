package com.Ebooks.Ebooks_api.UseCases.Book;

import com.Ebooks.Ebooks_api.Entity.Book;
import com.Ebooks.Ebooks_api.repositories.BookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteBookUseCase {
    private final BookRepository bookRepository;
    private final FindBookById findBookById;

    public void  execute(Long id){
        Book book = this.findBookById.execute(id);
        bookRepository.delete(book);
    }

}