package com.sparta.msa_exam.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupReqDto {

    private String username;
    private String password;
    private String email;

}