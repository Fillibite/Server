package com.example.hackathon.global.auth.jwt.filter;

import com.example.hackathon.domain.token.repository.RefreshTokenRepository;
import com.example.hackathon.domain.user.entity.User;
import com.example.hackathon.global.auth.PrincipalDetails;
import com.example.hackathon.global.auth.jwt.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenRepository tokenRepository;
    private final String secretKey;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(request.getInputStream(), User.class);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserEmail(), user.getUserPassword());

            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();

            return authentication;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        log.info("Login 성공!");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        JwtUtil.generateAndSendToken(response, principalDetails, tokenRepository, secretKey);
    }
}
