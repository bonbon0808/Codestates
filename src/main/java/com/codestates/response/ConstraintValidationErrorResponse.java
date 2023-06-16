package com.codestates.response;

import lombok.Getter;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

/**
 * <h3>애플리케이션 예외 처리 실습 과제용 Solution 코드 포함</h3>
 * ConstraintValidationErrorResponse는 애플리케이션에서 발생하는 예외를 이용해 클라이언트 측에 전달할 response body에 매핑되는 클래스입니다.
 * ConstraintValidationException을 통해서 얻은 에러에 대한 정보만 담는 Error Response입니다.
 * Solution 코드에 포함되는 코드는 아래와 같습니다.
 * <ul>
 *     <li>List<ConstraintViolationError> errors</li>
 *     <li>private ErrorResponse(int status, String message)</li>
 *     <li>{@link #of(Set<ConstraintViolation<?>>)}</li>
 * </ul>
 */
@Getter
public class ConstraintValidationErrorResponse {
    private List<ConstraintViolationError> errors;

    private ConstraintValidationErrorResponse(List<ConstraintViolationError> violationErrors) {
        this.errors = violationErrors;
    }

    public static ConstraintValidationErrorResponse of(Set<ConstraintViolation<?>> violations) {
        return new ConstraintValidationErrorResponse(ConstraintViolationError.of(violations));
    }
}