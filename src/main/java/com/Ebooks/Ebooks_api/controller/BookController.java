package com.Ebooks.Ebooks_api.controller;

import com.Ebooks.Ebooks_api.Dto.Input.CreateBookDto;
import com.Ebooks.Ebooks_api.Dto.Output.BookDto;
import com.Ebooks.Ebooks_api.Entity.Book;
import com.Ebooks.Ebooks_api.UseCases.Book.CreateBookUseCase;
import com.Ebooks.Ebooks_api.UseCases.Book.DeleteBookUseCase;
import com.Ebooks.Ebooks_api.UseCases.Book.FindBookById;
import com.Ebooks.Ebooks_api.UseCases.Book.GetAllBook;
import com.Ebooks.Ebooks_api.UseCases.FileUploadUseCase;
import com.Ebooks.Ebooks_api.exception.Http.HttpException;
import com.Ebooks.Ebooks_api.mappers.BookMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final CreateBookUseCase createBookUseCase;
    private final BookMapper bookMapper;
    private final FindBookById findBookById;
    private final DeleteBookUseCase deleteBookUseCase;
    private final GetAllBook getAllBook;
    private final FileUploadUseCase fileUploadUseCase;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAll() {
        List<Book> book =this.getAllBook.execute();
        List<BookDto>bookDtos= book.stream().map(this.bookMapper::toOutputDto).toList();
        return new ResponseEntity<>(bookDtos, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<BookDto> create(
            @ModelAttribute @Valid CreateBookDto dto,
            @RequestPart("image")MultipartFile image,
            HttpServletRequest request
            ) {
            try {
                Long userId = Long.valueOf(request.getAttribute("user_id").toString());
                Book book  = this.bookMapper.toEntity(dto);
                book.setUserId(userId);

                if (image != null && !image.isEmpty()) {
                    String imageUrl = this.fileUploadUseCase.execute(
                        userId +" /book",
                            UUID.randomUUID().toString(),
                            image
                    );
                    book.setImg(imageUrl);
                }

                return new ResponseEntity<>(
                        this.bookMapper.toOutputDto(
                                this.createBookUseCase.execute(book)
                        ),
                        HttpStatus.CREATED
                );
            } catch (Exception e) {
                throw new HttpException("Erro ao cadastrar produto" + e.getMessage(), HttpStatus.BAD_REQUEST);
            }


}
    @GetMapping("{id}")
    public ResponseEntity<BookDto> getById(@PathVariable("id") Long id){
        Book book = this.findBookById.execute(id);
        return new ResponseEntity<>(
            this.bookMapper.toOutputDto(book),
            HttpStatus.OK
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BookDto> delete(@PathVariable("id") Long id){
        this.deleteBookUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}

