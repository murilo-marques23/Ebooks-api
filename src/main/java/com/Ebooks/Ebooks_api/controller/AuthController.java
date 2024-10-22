package com.Ebooks.Ebooks_api.controller;

import com.Ebooks.Ebooks_api.Dto.Input.CreateUserDto;
import com.Ebooks.Ebooks_api.Dto.Input.UserLoginDto;
import com.Ebooks.Ebooks_api.Dto.Output.JwtLoginDto;
import com.Ebooks.Ebooks_api.Dto.Output.UserDto;
import com.Ebooks.Ebooks_api.Entity.User;
import com.Ebooks.Ebooks_api.UseCases.User.CreateUserUseCase;
import com.Ebooks.Ebooks_api.UseCases.User.LoginUserUseCase;
import com.Ebooks.Ebooks_api.exception.Http.UnauthorizedExceptionException;
import com.Ebooks.Ebooks_api.mappers.UserMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping
public class AuthController {
    private final CreateUserUseCase createUserUseCase;
    private final LoginUserUseCase loginUserUseCase;
    private final UserMapper userMapper;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody @Valid CreateUserDto dto) {
        User user = this.userMapper.toEntity(dto);

        user = createUserUseCase.execute(user);

        UserDto response = this.userMapper.toOutputDto(user);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/singin")
    public ResponseEntity<JwtLoginDto> login(@RequestBody @Valid UserLoginDto dto) {
        try {
            JwtLoginDto login = this.loginUserUseCase.execute(dto.getEmail(), dto.getPassword());
            return new ResponseEntity<>(login, HttpStatus.OK);
        } catch (Exception e) {
            throw new UnauthorizedExceptionException("Email e/ou senha Inválidos");
        }
    }

}
