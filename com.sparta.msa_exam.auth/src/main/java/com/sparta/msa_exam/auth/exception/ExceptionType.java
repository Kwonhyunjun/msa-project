package com.sparta.msa_exam.auth.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionType {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U-001", "주문을 찾을 수 없습니다."),
    USERNAME_DUPLICATED(HttpStatus.BAD_REQUEST, "U-002", "중복된 사용자가 존재합니다."),
    EMAIL_DUPLICATED(HttpStatus.BAD_REQUEST, "U-003", "중복된 이메일 입니다."),

    ;

    // 상태, 에러 코드, 메시지
    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;

    // 생성자
    ExceptionType(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
