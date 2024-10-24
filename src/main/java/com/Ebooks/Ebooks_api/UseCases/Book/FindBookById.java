package com.Ebooks.Ebooks_api.UseCases.Book;

import com.Ebooks.Ebooks_api.Entity.Book;
import com.Ebooks.Ebooks_api.exception.Http.NotFoundException;
import com.Ebooks.Ebooks_api.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindBookById {
  private final BookRepository bookRepository;

  public Book execute(Long id){
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("O Produto não pode ser encontrado"));
  }
}
