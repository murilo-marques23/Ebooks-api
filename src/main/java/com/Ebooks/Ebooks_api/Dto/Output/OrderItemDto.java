package com.Ebooks.Ebooks_api.Dto.Output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    @JsonProperty("order_id")
    private Long orderId;
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("unit_price")
    private Long unitPrice;
    private Integer quantity;
    private BookDto book;
}
