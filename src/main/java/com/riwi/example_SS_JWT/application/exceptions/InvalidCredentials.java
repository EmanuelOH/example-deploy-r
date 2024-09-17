package com.riwi.example_SS_JWT.application.exceptions;

import com.riwi.example_SS_JWT.application.dtos.exceptions.ExceptionBasic;
import com.riwi.example_SS_JWT.application.dtos.exceptions.ExceptionResponse;
import com.riwi.example_SS_JWT.domain.exceptions.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class InvalidCredentials {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ExceptionBasic invalidCredentialsException(InvalidCredentialsException exception){

        return ExceptionResponse.builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .status(HttpStatus.UNAUTHORIZED.name())
                .message(exception.getMessage())
                .build();
    }
}
