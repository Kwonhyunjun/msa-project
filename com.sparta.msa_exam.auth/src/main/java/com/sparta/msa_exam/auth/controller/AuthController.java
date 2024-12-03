package com.sparta.msa_exam.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.msa_exam.auth.dto.SignupReqDto;
import com.sparta.msa_exam.auth.jwt.JwtUtil;
import com.sparta.msa_exam.auth.service.AuthService;
import com.sparta.msa_exam.auth.service.KakaoService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
    private final KakaoService kakaoService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignupReqDto signupRequestDto){

        log.info("username : {}", signupRequestDto.getUsername());
        log.info("password : {}", signupRequestDto.getPassword());
        log.info("eamil : {}", signupRequestDto.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(authService.signUp(signupRequestDto));
    }

    @GetMapping("/sign-in")
    public ResponseEntity<?> kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {

        log.info("code : {}", code);
        String token = kakaoService.kakaoLogin(code);

        log.info("token : {}", token);

        Cookie cookie = new Cookie(JwtUtil.AUTHORIZATION_HEADER, token.substring(7));
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
