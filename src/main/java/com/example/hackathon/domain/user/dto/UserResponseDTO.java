package com.example.hackathon.domain.user.dto;

import com.example.hackathon.domain.user.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class UserResponseDTO {
    @Setter
    @Getter
    public static class UserJoinDTO {
        private Long id;
        private String userEmail;
        private String userPassword;
        private String userName;

        public UserJoinDTO(User user) {
            this.id = user.getId();
            this.userEmail = user.getUserEmail();
            this.userPassword = user.getUserPassword();
            this.userName = user.getUserName();
        }
    }
    @Setter
    @Getter
    public static class UserLoginDTO {
        private String accessToken;
    }
}
