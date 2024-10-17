package com.Ebooks.Ebooks_api.Dto.Output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String Nome;
    private String autor;
    private String preco;
    private String img;
    private Integer score;
    private Long id;
}

