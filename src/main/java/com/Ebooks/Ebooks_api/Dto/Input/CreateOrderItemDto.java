package com.Ebooks.Ebooks_api.Dto.Input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderItemDto {
    @JsonProperty("product_id")
    private Long productId;
    private Integer quantity;
}
