package com.Ebooks.Ebooks_api.exception.Http;

public class UserTokenExpiredException extends RuntimeException {
    public UserTokenExpiredException(String message) {
        super(message);
    }
}
