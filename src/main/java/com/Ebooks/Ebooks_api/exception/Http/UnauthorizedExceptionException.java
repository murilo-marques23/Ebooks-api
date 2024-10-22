package com.Ebooks.Ebooks_api.exception.Http;

import org.springframework.http.HttpStatus;

public class UnauthorizedExceptionException extends HttpException{
    public UnauthorizedExceptionException(String message){
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
