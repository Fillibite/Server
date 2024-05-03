package com.example.hackathon.global.auth.oauth2.handler;

import com.example.hackathon.global.auth.PrincipalDetails;
import com.example.hackathon.global.auth.jwt.util.JwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class Oauth2LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Value(("${jwt.secret}"))
    private String secretKey;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("OAuth2 Login 성공!");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        JwtUtil.generateAndSendToken(response, principalDetails, secretKey);
    }
}
