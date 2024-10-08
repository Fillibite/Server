package com.example.hackathon.global.auth.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.hackathon.global.auth.PrincipalDetails;
import com.example.hackathon.global.auth.jwt.JwtProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtil {

    public static void generateToken(HttpServletResponse response, PrincipalDetails principalDetails, String secretKey) throws IOException {
        String accessToken = createToken("accessToken", JwtProperties.REFRESH_EXPIRATION_TIME, principalDetails, secretKey);
//        String refreshToken = createToken("refreshToken", JwtProperties.REFRESH_EXPIRATION_TIME, principalDetails, secretKey);

        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + accessToken);
//        tokenRepository.save(new RefreshToken(refreshToken, principalDetails.getUser().getId()));

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("accessToken", accessToken);
//        tokenMap.put("refreshToken", refreshToken);
        response.setContentType("application/json");

//        log.info("Access Token : " + accessToken);
//        log.info("Refresh Token : " + refreshToken);

        new ObjectMapper().writeValue(response.getOutputStream(), tokenMap);
    }

//    public static void generateOauth2Token(HttpServletResponse response, PrincipalDetails principalDetails, String secretKey) throws IOException {
//        String accessToken = createToken("accessToken", JwtProperties.REFRESH_EXPIRATION_TIME, principalDetails, secretKey);
////        String refreshToken = createToken("refreshToken", JwtProperties.REFRESH_EXPIRATION_TIME, principalDetails, secretKey);
//
//        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + accessToken);
////        tokenRepository.save(new RefreshToken(refreshToken, principalDetails.getUser().getId()));
//
//        Map<String, String> tokenMap = new HashMap<>();
//        tokenMap.put("accessToken", accessToken);
////        tokenMap.put("refreshToken", refreshToken);
//        response.setContentType("application/json");
//
////        log.info("Access Token : " + accessToken);
////        log.info("Refresh Token : " + refreshToken);
//
//        System.out.println("------------1");
//        new ObjectMapper().writeValue(response.getOutputStream(), tokenMap);
//        System.out.println("------------2");
//        String redirectUrl = UriComponentsBuilder.fromUriString("/auth/success")
//                .queryParam("accessToken", accessToken)
//                .build().toUriString();
//
//        response.sendRedirect(redirectUrl);
//    }

    private static String createToken(String type, long expirationTime, PrincipalDetails principalDetails, String secretKey) {
        String token = JWT.create()
                .withSubject(type)  // subject 변경
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime)) // 만료 시간 변경
                .withClaim("userEmail", principalDetails.getUser().getUserEmail())
                .withClaim("role", principalDetails.getUser().getRole())
                .sign(Algorithm.HMAC512(secretKey));
        return token;
    }
}

