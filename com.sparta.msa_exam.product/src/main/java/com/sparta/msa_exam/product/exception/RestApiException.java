package com.sparta.msa_exam.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestApiException {
    private String errorMessage;
    private String errorCode;
    private int statusCode;
}
