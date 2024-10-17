package com.Ebooks.Ebooks_api.Dto.Output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    @JsonProperty("payment_url")
    private String paymentUrl;
}
