package com.Ebooks.Ebooks_api.exception.Http;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpException(String message, HttpStatus status){
        super(message);
        this.httpStatus = status;
    }
}
