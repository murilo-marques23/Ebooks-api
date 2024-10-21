package com.Ebooks.Ebooks_api.controller;

import com.Ebooks.Ebooks_api.Dto.Output.BookDto;
import com.Ebooks.Ebooks_api.UseCases.Book.CreateBookUseCase;
import com.Ebooks.Ebooks_api.UseCases.Book.DeleteBookUseCase;
import com.Ebooks.Ebooks_api.UseCases.Book.FindBookById;
import com.Ebooks.Ebooks_api.UseCases.Book.GetAllBookById;
import com.Ebooks.Ebooks_api.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final CreateBookUseCase createBookUseCase;
    private final BookMapper bookMapper;
    private final FindBookById findBookById;
    private final DeleteBookUseCase deleteBookUseCase;
    private final GetAllBookById getAllBookById;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAll() {

    }
}
