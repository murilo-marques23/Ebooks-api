package com.Ebooks.Ebooks_api.Dto.Output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtLoginDto {
    private String access_token;
    private Instant expires_in;
}
