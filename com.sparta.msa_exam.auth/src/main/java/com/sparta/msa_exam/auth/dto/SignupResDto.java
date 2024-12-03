package com.sparta.msa_exam.auth.dto;

import com.sparta.msa_exam.auth.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResDto {

    private Long id;
    private String username;
    private String email;

    public SignupResDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}