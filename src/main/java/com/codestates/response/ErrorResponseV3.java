package com.codestates.response;

import lombok.Getter;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

/**
 * <h3>애플리케이션 예외 처리 실습 과제용 Solution 코드 포함</h3>
 * BindingResultErrorResponse는 애플리케이션에서 발생하는 예외를 이용해 클라이언트 측에 전달할 response body에 매핑되는 클래스입니다.
 * DTO 필드의 유효성 검증 에러에 대한 정보만 담는 Error Response입니다.
 * Solution 코드에 포함되는 코드는 아래와 같습니다.
 * <ul>
 *     <li>List<FieldError> errors</li>
 *     <li>private ErrorResponse(int status, String message)</li>
 *     <li>{@link #of(BindingResult)}</li>
 * </ul>
 */
@Getter
public class ErrorResponseV3 {
    private List<Error> errors;

    private ErrorResponseV3(List<Error> errors) {
        this.errors = errors;
    }

    public static ErrorResponseV3 of(BindingResult bindingResult) {
        List<Error> fieldError = FieldError.of(bindingResult);
        return new ErrorResponseV3(fieldError);
    }

    public static ErrorResponseV3 of(Set<ConstraintViolation<?>> violations) {
        List<Error> constraintViolationErrors = ConstraintViolationError.of(violations);
        return new ErrorResponseV3(constraintViolationErrors);
    }
}