package com.Ebooks.Ebooks_api.mappers;

import com.Ebooks.Ebooks_api.Dto.Input.CreateBookDto;
import com.Ebooks.Ebooks_api.Dto.Output.BookDto;
import org.mapstruct.Mapper;

import java.awt.print.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity(CreateBookDto dto);

    BookDto toOutputDto(Book book);
}
