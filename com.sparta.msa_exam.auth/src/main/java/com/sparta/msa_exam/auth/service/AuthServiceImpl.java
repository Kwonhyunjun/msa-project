package com.sparta.msa_exam.auth.service;

import com.sparta.msa_exam.auth.dto.SignupReqDto;
import com.sparta.msa_exam.auth.dto.SignupResDto;
import com.sparta.msa_exam.auth.entity.User;
import com.sparta.msa_exam.auth.exception.CustomException;
import com.sparta.msa_exam.auth.exception.ExceptionType;
import com.sparta.msa_exam.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public SignupResDto signUp(SignupReqDto signupRequestDto) {
        String username = signupRequestDto.getUsername();
        String email = signupRequestDto.getEmail();
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new CustomException(ExceptionType.USERNAME_DUPLICATED);
        }

        Optional<User> checkEmail = userRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new CustomException(ExceptionType.EMAIL_DUPLICATED);
        }

        User save = userRepository.save(new User(username, password, email));

        return new SignupResDto(save);
    }
}
