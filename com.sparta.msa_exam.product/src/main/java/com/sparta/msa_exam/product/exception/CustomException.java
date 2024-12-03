package com.sparta.msa_exam.product.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private ExceptionType exceptionType;

    public CustomException(ExceptionType exceptionType){
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}