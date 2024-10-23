package com.Ebooks.Ebooks_api.Validation;

import com.Ebooks.Ebooks_api.exception.Http.UnauthorizedExceptionException;
import com.Ebooks.Ebooks_api.exception.Http.UserTokenExpiredException;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class ValidationTokenUseCase {

    private final JWTVerifier jwtVerifier;

    public DecodedJWT execute(String token){
        try {
            DecodedJWT decode = this.jwtVerifier.verify(token);
            LocalDateTime tokenExpiration = decode.getExpiresAt()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            if(LocalDateTime.now().isAfter(tokenExpiration)){
                throw new UserTokenExpiredException("Token expirado");
            }

            return decode;
        }catch (Exception e){
            throw new UnauthorizedExceptionException("Invalid or expired Token");
        }
    }}