package com.Ebooks.Ebooks_api.exception.Http;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
