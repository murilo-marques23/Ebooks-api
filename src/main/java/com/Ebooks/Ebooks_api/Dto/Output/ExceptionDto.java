package com.Ebooks.Ebooks_api.Dto.Output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDto {
    private String message;
    private HttpStatus status;
}
