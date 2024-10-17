package com.Ebooks.Ebooks_api.Dto.Input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookDto {
    @NotEmpty
    private String Nome;
    private String autor;
    private String preco;
    private String img;
    private Integer score;
    @JsonProperty("category_id")
    private Long id;
}
