package com.Ebooks.Ebooks_api.Filter;

import com.Ebooks.Ebooks_api.Entity.User;
import com.Ebooks.Ebooks_api.UseCases.User.GetUserByEmailUseCase;
import com.Ebooks.Ebooks_api.UseCases.User.GetUserByIdUseCase;
import com.Ebooks.Ebooks_api.Validation.ValidationTokenUseCase;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final ValidationTokenUseCase validationTokenUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException

    {
        String header = request.getHeader("Authorization");
        if(header == null){
            filterChain.doFilter(request, response);
            return;
        }

        DecodedJWT tokenDecoded = this.validationTokenUseCase.execute(header.replace("Bearer", ""));
        Long userId = Long.valueOf(tokenDecoded.getSubject());
        User user = this.getUserByIdUseCase.execute(userId);

        request.setAttribute("user_id", Long.valueOf(tokenDecoded.getSubject()));

        UsernamePasswordAuthenticationToken authUser = new UsernamePasswordAuthenticationToken(
                user,
                null

        );
        SecurityContextHolder.getContext().setAuthentication(authUser);

        filterChain.doFilter(request,response);
    }

}
