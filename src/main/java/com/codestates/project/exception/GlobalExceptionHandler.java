package com.codestates.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler 클래스는 전역 예외 처리를 담당합니다.
 * @RestControllerAdvice 어노테이션을 통해 예외를 처리하고 ErrorResponse를 반환합니다.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * CustomException 예외를 처리하는 메서드입니다.
     * CustomException이 발생하면 해당 예외에 맞는 ErrorResponse를 생성하여 클라이언트에게 반환합니다.
     * @param e CustomException 객체
     * @return ResponseEntity<ErrorResponse> ErrorResponse를 담은 ResponseEntity
     */
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), e.getHttpStatusCode());
        return new ResponseEntity<>(errorResponse, e.getHttpStatus());
    }

    /**
     * RuntimeException 예외를 처리하는 메서드입니다.
     * RuntimeException이 발생하면 내부 서버 오류로 간주하고, 기본적인 내부 서버 오류 메시지를 ErrorResponse에 담아 클라이언트에게 반환합니다.
     * @param e RuntimeException 객체
     * @return ResponseEntity<ErrorResponse> ErrorResponse를 담은 ResponseEntity
     */
    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<ErrorResponse> handleRuntimeException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
