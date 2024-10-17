package com.Ebooks.Ebooks_api.Settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderSettings {
    @Bean
    public PasswordEncoder setup(){
        return new BCryptPasswordEncoder();
    }
}
