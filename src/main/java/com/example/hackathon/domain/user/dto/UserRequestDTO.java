package com.example.hackathon.domain.user.dto;

import com.example.hackathon.domain.user.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserRequestDTO {
    @Setter
    @Getter
    public static class UserJoinDTO {
        private String userEmail;
        private String userPassword;
        private String userName;
        public User toEntity() {
            return new User(this.userEmail, this.userPassword, this.userName);
        }
    }
    @Setter
    @Getter
    public static class UserLoginDTO {
        private String accessToken;
    }
}