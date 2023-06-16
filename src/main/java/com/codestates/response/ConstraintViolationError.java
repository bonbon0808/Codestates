package com.codestates.response;

import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ConstraintViolationError {
    private String propertyPath;
    private Object rejectedValue;
    private String reason;

    private ConstraintViolationError(String propertyPath, Object rejectedValue,
                                     String reason) {
        this.propertyPath = propertyPath;
        this.rejectedValue = rejectedValue;
        this.reason = reason;
    }

    public static List<ConstraintViolationError> of(Set<ConstraintViolation<?>> constraintViolations) {
        // TODO Convert 공통화
        return constraintViolations.stream()
                .map(constraintViolation -> new ConstraintViolationError(
                        constraintViolation.getPropertyPath().toString(),
                        constraintViolation.getInvalidValue().toString(),
                        constraintViolation.getMessage()
                )).collect(Collectors.toList());
    }
}
