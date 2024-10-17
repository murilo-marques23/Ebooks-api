package com.Ebooks.Ebooks_api.Dto.Input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    @NotEmpty
    private String name;
    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;
    @NotEmpty
    @Email
    private String email;
}
