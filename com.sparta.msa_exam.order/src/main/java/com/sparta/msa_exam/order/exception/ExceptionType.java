package com.sparta.msa_exam.order.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionType {
    ORDER_NOT_FOUND(HttpStatus.NOT_FOUND, "O-001", "주문을 찾을 수 없습니다."),
    PRODUCT_NOT_MATCH(HttpStatus.BAD_REQUEST, "O-002", "추가하려는 상품을 찾을 수 없습니다.");

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
