package com.example.hackathon.domain.user.entity;

import com.example.hackathon.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
@Getter
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String role = "ROLE_USER";
    private String userEmail;
    private String userPassword;
    private String userName;

    public List<String> getRoleList() {
        if (this.role.length() > 0) {
            return Arrays.asList(this.role.split(","));
        }
        return new ArrayList<>();
    }

    /** ======================== 생성자 ======================== **/
    public User() {

    }

    public User(Long id, String role, String userEmail, String userPassword, String userName) {
        this.id = id;
        this.role = role;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
    }

}
