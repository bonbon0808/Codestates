package com.codestates.response;

import com.codestates.exception.ExceptionCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <h3>애플리케이션 예외 처리 실습 과제용 Solution 코드 포함</h3>
 * ErrorResponse는 애플리케이션에서 발생하는 예외를 이용해 클라이언트 측에 전달할 response body에 매핑되는 클래스입니다.
 * Validation 에러에 대한 정보만 담는 ErrorResponse입니다.
 * Solution 코드에 포함되는 코드는 아래와 같습니다.
 * <ul>
 *     <li>int status</li>
 *     <li>String message</li>
 *     <li>private ErrorResponse(int status, String message)</li>
 *     <li>{@link #of(BindingResult)}</li>
 *     <li>{@link #of(Set<ConstraintViolation<?>>)}</li>
 * </ul>
 */
@Getter
public class ValidationErrorResponse {
    private List<FieldError> fieldErrors;
    private List<ConstraintViolationError> violationErrors;

    private ValidationErrorResponse(List<FieldError> fieldErrors,
                                    List<ConstraintViolationError> violationErrors) {
        this.fieldErrors = fieldErrors;
        this.violationErrors = violationErrors;
    }

    public static ValidationErrorResponse of(BindingResult bindingResult) {
        return new ValidationErrorResponse(FieldError.of(bindingResult), null);
    }

    public static ValidationErrorResponse of(Set<ConstraintViolation<?>> violations) {
        return new ValidationErrorResponse(null, ConstraintViolationError.of(violations));
    }

    @Getter
    public static class FieldError {
        private String field;
        private Object rejectedValue;
        private String reason;

        private FieldError(String field, Object rejectedValue, String reason) {
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        private static List<FieldError> of(BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors =
                                                        bindingResult.getFieldErrors();
            return null; // TODO Converter 이용
        }
    }

    @Getter
    public static class ConstraintViolationError {
        private String propertyPath;
        private Object rejectedValue;
        private String reason;

        private ConstraintViolationError(String propertyPath, Object rejectedValue,
                                   String reason) {
            this.propertyPath = propertyPath;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        private static List<ConstraintViolationError> of(
                Set<ConstraintViolation<?>> constraintViolations) {
            return null; // TODO Converter 이용
        }
    }

    private static class ValidationErrorResponseConverter {
        private static List<Object> convert(Object object) {
            // TODO 에러 정보 변환(공통화)
            return null;
        }
    }
}