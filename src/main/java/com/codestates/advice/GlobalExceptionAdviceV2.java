package com.codestates.advice;

import com.codestates.response.v2.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.validation.ConstraintViolationException;

/**
 * MethodArgumentNotValidException 처리
 *  - ErrorResponse.of(e.getBindingResult())를 이용해서 에러에 대한 구체적인 정보를 ErrorResponse가 만든다.
 * ConstraintViolationException 처리
 *  - ErrorResponse.of(e.getConstraintViolations())를 이용해서 에러에 대한 구체적인 정보를 ErrorResponse가 만든다.
 */
//@RestControllerAdvice
public class GlobalExceptionAdviceV2 {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        final ErrorResponse response = ErrorResponse.of(e.getBindingResult());

        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(
            ConstraintViolationException e) {
        final ErrorResponse response = ErrorResponse.of(e.getConstraintViolations());

        return response;
    }
}
