package com.sparta.msa_exam.auth.service;

import com.sparta.msa_exam.auth.dto.SignupReqDto;
import com.sparta.msa_exam.auth.dto.SignupResDto;

public interface AuthService {

    SignupResDto signUp(SignupReqDto signupRequestDto);

}
