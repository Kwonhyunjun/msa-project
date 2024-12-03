package com.sparta.msa_exam.auth.controller;

import com.sparta.msa_exam.auth.dto.SignupReqDto;
import com.sparta.msa_exam.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignupReqDto signupRequestDto){

        log.info("username : {}", signupRequestDto.getUsername());
        log.info("password : {}", signupRequestDto.getPassword());
        log.info("eamil : {}", signupRequestDto.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(authService.signUp(signupRequestDto));
    }

}
