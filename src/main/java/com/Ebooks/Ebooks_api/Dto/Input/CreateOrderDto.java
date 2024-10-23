package com.Ebooks.Ebooks_api.Dto.Input;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {
    @NotEmpty
    private List<CreateOrderItemDto> book;
}
