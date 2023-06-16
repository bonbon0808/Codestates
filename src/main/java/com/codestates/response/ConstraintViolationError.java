package com.codestates.response;

import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ConstraintViolationError implements Error {
    private String field;
    private String rejectedValue;
    private String reason;

    private ConstraintViolationError(String propertyPath, String rejectedValue,
                                     String reason) {
        this.field = propertyPath;
        this.rejectedValue = rejectedValue;
        this.reason = reason;
    }

    public static List<Error> of(Set<ConstraintViolation<?>> constraintViolations) {
        // TODO Convert 공통화
        return constraintViolations.stream()
                .map(constraintViolation -> new ConstraintViolationError(
                        constraintViolation.getPropertyPath().toString(),
                        constraintViolation.getInvalidValue().toString(),
                        constraintViolation.getMessage()
                )).collect(Collectors.toList());
    }
}
