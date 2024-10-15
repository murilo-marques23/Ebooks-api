package com.Ebooks.Ebooks_api.Settings;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtSettings {
    @Value("${app.jwt.secret}")
    private String secret;

    @Bean
    public Algorithm setUpAlgorithm(){
        return Algorithm.HMAC256(secret);
    }
}
