package com.Ebooks.Ebooks_api.Dto.Output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputErrorDto {
    private String field;
    private String message;
}
