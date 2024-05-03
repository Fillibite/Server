package com.example.hackathon.global.auth.service;

import com.example.hackathon.domain.user.entity.User;
import com.example.hackathon.global.auth.PrincipalDetails;
import com.example.hackathon.global.common.exception.CustomException;
import com.example.hackathon.global.common.reponse.ErrorCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public String getCurrentAuthenticatedUserEmail() throws CustomException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof PrincipalDetails) {
                return ((PrincipalDetails) principal).getEmail();
            }
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
        throw new CustomException(ErrorCode.ACCESS_DENIED);
    }

    public User getCurrentAuthenticatedUser() throws CustomException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof PrincipalDetails) {
                return ((PrincipalDetails) principal).getUser();
            }
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
        throw new CustomException(ErrorCode.ACCESS_DENIED);
    }
}
