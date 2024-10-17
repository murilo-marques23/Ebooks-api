package com.Ebooks.Ebooks_api.Dto.Output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    @JsonProperty("total_price")
    private Long totalPrice;
    private List<OrderItemDto> items;
}
